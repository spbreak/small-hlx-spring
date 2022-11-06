package cn.hlx.springframework.aop.framework.autoproxy;

import cn.hlx.springframework.aop.*;
import cn.hlx.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.hlx.springframework.aop.framework.ProxyFactory;
import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.BeanFactory;
import cn.hlx.springframework.beans.factory.BeanFactoryAware;
import cn.hlx.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.hlx.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * BeanPostProcessor implementation that creates AOP proxies based on all candidate
 * Advisors in the current BeanFactory. This class is completely generic; it contains
 * no special code to handle any particular aspects, such as pooling aspects.
 * <p>
 *     
 *     
 *     
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    
    private DefaultListableBeanFactory beanFactory;
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
    
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        
        if (isInfrastructureClass(beanClass)) return null;
        
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(beanClass)) continue;

            AdvisedSupport advisedSupport = new AdvisedSupport();
            
            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);
            
            return new ProxyFactory(advisedSupport).getProxy();
            
        }
        
        return null;
    }
    
    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
    
    @Override 
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
    
}
