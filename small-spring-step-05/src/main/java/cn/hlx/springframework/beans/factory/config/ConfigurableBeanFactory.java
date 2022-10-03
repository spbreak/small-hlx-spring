package cn.hlx.springframework.beans.factory.config;

import cn.hlx.springframework.beans.factory.HierarchicalBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    
    String SCOPE_SINGLETON = "singleton";
    
    String SCOPE_PROTOTYPE = "prototype";
}
