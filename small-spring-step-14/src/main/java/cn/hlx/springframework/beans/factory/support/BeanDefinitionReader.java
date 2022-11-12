package cn.hlx.springframework.beans.factory.support;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.core.io.Resource;
import cn.hlx.springframework.core.io.ResourceLoader;

/**
 * Simple interface for bean definition readers.
 *
 * 
 * 
 * 
 */
public interface BeanDefinitionReader {
    
    BeanDefinitionRegistry getRegistry();
    
    ResourceLoader getResourceLoader();
    
    void loadBeanDefinitions(Resource resource) throws BeansException;
    
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    
    void loadBeanDefinitions(String location) throws BeansException;
    
    void loadBeanDefinitions(String... locations) throws BeansException;
    
}
