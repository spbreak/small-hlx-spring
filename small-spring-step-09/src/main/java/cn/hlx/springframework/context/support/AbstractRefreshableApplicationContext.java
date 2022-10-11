package cn.hlx.springframework.context.support;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.hlx.springframework.beans.factory.support.DefaultListableBeanFactory;

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }
    
    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }
    
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
