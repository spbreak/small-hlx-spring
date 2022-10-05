package cn.hlx.springframework.context;

import cn.hlx.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * 
     * @throws BeansException
     */
    void refreash() throws BeansException;
}
