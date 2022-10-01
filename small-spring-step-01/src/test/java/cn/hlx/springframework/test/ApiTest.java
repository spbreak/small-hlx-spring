package cn.hlx.springframework.test;

import cn.hlx.springframework.BeanDefinition;
import cn.hlx.springframework.BeanFactory;
import cn.hlx.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
    
    @Test
    public void test_BeanFactory() {
        // 1. 初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        
        // 2. 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        
        // 3. 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
