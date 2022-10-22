package cn.hlx.springframework.beans.factory;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.hlx.springframework.beans.factory.config.BeanDefinition;
import cn.hlx.springframework.beans.factory.config.BeanPostProcessor;
import cn.hlx.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 
 * 
 * 
 * 沉淀-分享-成长, 让自己和他人都能有所收获
 * 
 * 
 * 
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    
    void preInstantiateSingletons() throws BeansException;
    
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
    
}
