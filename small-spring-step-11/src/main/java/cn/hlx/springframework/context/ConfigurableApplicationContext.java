package cn.hlx.springframework.context;

import cn.hlx.springframework.beans.BeansException;

/**
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link cn.hlx.springframework.context.ApplicationContext} interface.
 *
 * 
 * 
 * 
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * 
     * @throws BeansException
     */
    void refresh() throws BeansException;
    
    void registerShutdownHook();
    
    void close();
}
