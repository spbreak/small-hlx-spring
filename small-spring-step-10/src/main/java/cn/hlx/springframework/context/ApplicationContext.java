package cn.hlx.springframework.context;

import cn.hlx.springframework.beans.factory.HierarchicalBeanFactory;
import cn.hlx.springframework.beans.factory.ListableBeanFactory;
import cn.hlx.springframework.core.io.ResourceLoader;

/**
 * 应用上下文
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
    
}
