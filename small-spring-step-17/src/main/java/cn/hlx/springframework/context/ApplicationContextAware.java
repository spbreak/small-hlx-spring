package cn.hlx.springframework.context;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.Aware;

/**
 * Interface to be implemented by any object that wishes to be notified
 * of the {@link ApplicationContext} that it runs in.
 *
 * 实现此接口，既能感知到所属的 ApplicationContext
 *
 * 
 * 
 * 
 */
public interface ApplicationContextAware extends Aware {
    
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
    
}
