package cn.hlx.springframework.context.support;

import cn.hlx.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.hlx.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Convenient base class for {@link cn.hlx.springframework.context.ApplicationContext}
 * implementations, drawing configuration from XML documents containing bean definitions
 * understood by an {@link cn.hlx.springframework.beans.factory.xml.XmlBeanDefinitionReader}.
 *
 * 
 * 
 * 
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }
    
    protected abstract String[] getConfigLocations();
}
