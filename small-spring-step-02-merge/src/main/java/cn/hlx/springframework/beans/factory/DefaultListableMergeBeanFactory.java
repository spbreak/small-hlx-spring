package cn.hlx.springframework.beans.factory;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableMergeBeanFactory {

    // 一
    // ====BEGIN=singleton(实例化后的Bean)====
    // DefaultSingletonBeanRegistry成员
    // 业务性: 简单的set和get, 并没有创建或存入等双业务(组合业务)处理
    private final Map<String, Object> singletonObjects = new HashMap<>();

    // 接口
    // SingletonBeanRegistry接口定义-DefaultSingletonBeanRegistry实现
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    // DefaultSingletonBeanRegistry类实现
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
    // ====BEGIN=singleton(实例化后的Bean)====
    
    // 二
    // ====BEGIN=获取Bean====
    // 接口
    // BeanFactory接口定义-AbstractBeanFactory抽象类实现
    // 业务性: 获取实例-没有就创建(双业务/组合业务)
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }
    // ====END=获取Bean====

    // 三
    // ====BEGIN=Bean实例化相关====
    // 抽象接口
    // AbstractBeanFactory抽象类定义-AbstractAutowiredCapableBeanFactory实现
    // 业务性: 创建并存入容器(双业务/组合业务)
    public Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
    // ====END=Bean实例化相关====
    
    // 四
    // ====BEGIN=BeanDefinition相关====
    // DefaultListableBeanFactory成员
    // 业务性: 简单的set和get, 并没有创建或存入等双业务(组合业务)处理
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    // 接口
    // BeanDefinitionRegistry接口定义-DefaultListableBeanFactory实现
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    // 抽象接口
    // AbstractBeanFactory抽象类定义-DefaultListableBeanFactory实现
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }
    // ====END=BeanDefinition相关====
    
}
