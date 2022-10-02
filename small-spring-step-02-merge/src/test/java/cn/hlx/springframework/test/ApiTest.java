package cn.hlx.springframework.test;

import cn.hlx.springframework.beans.factory.DefaultListableMergeBeanFactory;
import cn.hlx.springframework.beans.factory.config.BeanDefinition;
import cn.hlx.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.hlx.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
    
    @Test
    public void test_BeanFactory() {
        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        
        //2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        
        //3. 第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        
        //4. 第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();
    }
    
    @Test
    public void test_MergeBeanFactory() {
        DefaultListableMergeBeanFactory beanFactory = new DefaultListableMergeBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3. 第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        //4. 第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();
    }
}
