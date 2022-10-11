package cn.hlx.springframework.context;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.Aware;

/**
 * 实现此接口, 既能感知到所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware {
    
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
