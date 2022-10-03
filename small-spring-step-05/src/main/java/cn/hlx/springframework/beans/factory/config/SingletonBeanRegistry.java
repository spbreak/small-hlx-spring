package cn.hlx.springframework.beans.factory.config;

public interface SingletonBeanRegistry {
    
    Object getSingleton(String beanName);
    
}
