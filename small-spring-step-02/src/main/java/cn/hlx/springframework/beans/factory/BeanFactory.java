package cn.hlx.springframework.beans.factory;

import cn.hlx.springframework.beans.BeansException;

public interface BeanFactory {
    
    Object getBean(String name) throws BeansException;
}
