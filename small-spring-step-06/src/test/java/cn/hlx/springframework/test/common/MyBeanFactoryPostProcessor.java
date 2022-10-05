package cn.hlx.springframework.test.common;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.PropertyValue;
import cn.hlx.springframework.beans.PropertyValues;
import cn.hlx.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.hlx.springframework.beans.factory.config.BeanDefinition;
import cn.hlx.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 后置处理BeanFactory
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        
        propertyValues.addPropertyValue(new PropertyValue("company", "改为: 字节跳不动"));
    }
    
}
