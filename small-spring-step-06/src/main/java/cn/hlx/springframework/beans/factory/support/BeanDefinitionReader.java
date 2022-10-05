package cn.hlx.springframework.beans.factory.support;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.core.io.Resource;
import cn.hlx.springframework.core.io.ResourceLoader;

/**
 * 沉淀-分享-成长, 让自己和他人都能有所收获
 */
public interface BeanDefinitionReader {
    
    BeanDefinitionRegistry getRegistry();
    
    ResourceLoader getResourceLoader();
    
    void loadBeanDefinitions(Resource resource) throws BeansException;
    
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    
    void loadBeanDefinitions(String location) throws BeansException;
    
    void loadBeanDefinitions(String... locations) throws BeansException;
    
}
