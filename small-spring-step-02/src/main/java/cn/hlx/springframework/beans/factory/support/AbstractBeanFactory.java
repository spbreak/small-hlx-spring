package cn.hlx.springframework.beans.factory.support;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.BeanFactory;
import cn.hlx.springframework.beans.factory.config.BeanDefinition;

public abstract class   AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }
    
    public abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    
    public abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
