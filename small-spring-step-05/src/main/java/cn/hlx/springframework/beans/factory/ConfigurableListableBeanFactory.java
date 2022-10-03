package cn.hlx.springframework.beans.factory;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.hlx.springframework.beans.factory.config.BeanDefinition;
import cn.hlx.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    
}
