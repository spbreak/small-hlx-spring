package cn.hlx.springframework.context.event;

import cn.hlx.springframework.beans.factory.BeanFactory;
import cn.hlx.springframework.context.ApplicationEvent;
import cn.hlx.springframework.context.ApplicationListener;

/**
 * Simple implementation of the {@link ApplicationEventMulticaster} interface.
 * <p>
 * 
 * 
 * 
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
    
}
