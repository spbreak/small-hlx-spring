package cn.hlx.springframework.beans.factory;

import cn.hlx.springframework.beans.BeansException;

/**
 * 
 * 
 * 
 * 实现该接口, 既能感知所属的 BeanFactory
 * 
 * 
 * 
 * 
 */
public interface BeanFactoryAware extends Aware {
    
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
    
}
