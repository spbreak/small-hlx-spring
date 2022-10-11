package cn.hlx.springframework.beans.factory.support;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.BeanFactory;
import cn.hlx.springframework.beans.factory.FactoryBean;
import cn.hlx.springframework.beans.factory.config.BeanDefinition;
import cn.hlx.springframework.beans.factory.config.BeanPostProcessor;
import cn.hlx.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.hlx.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    
    /** BeanPostPorcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 如果是 FactoryBean, 则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }
    
    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        
        Object object = getCachedObjectForFactoryBean(beanName);
        
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        
        return object;
    }
    
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }
    
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
    
    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
