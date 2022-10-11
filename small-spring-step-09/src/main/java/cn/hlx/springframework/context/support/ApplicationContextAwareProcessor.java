package cn.hlx.springframework.context.support;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.config.BeanPostProcessor;
import cn.hlx.springframework.context.ApplicationContext;
import cn.hlx.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    
    private final ApplicationContext applicationContext;
    
    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext); 
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
