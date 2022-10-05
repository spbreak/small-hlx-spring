package cn.hlx.springframework.context.support;

import cn.hlx.springframework.beans.BeansException;

/**
 * XML 文件对应上下文
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    
    private String[] configLocations;
    
    public ClassPathXmlApplicationContext() {
        
    }

    /**
     * 从 XML 中加载 BeanDefinition, 并刷新上下文
     * 
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }
    
    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refreash();
    }
    
    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
