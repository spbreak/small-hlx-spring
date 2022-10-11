package cn.hlx.springframework.beans.factory.support;

import cn.hlx.springframework.core.io.DefaultResourceLoader;
import cn.hlx.springframework.core.io.ResourceLoader;

/**
 * 沉淀-分享-成长, 让自己和他人都有所收获
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    
    private final BeanDefinitionRegistry registry;
    
    private ResourceLoader resourceLoader;
    
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }
    
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
