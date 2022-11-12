package cn.hlx.springframework.test;

import cn.hlx.springframework.beans.BeansException;
import cn.hlx.springframework.beans.factory.config.BeanPostProcessor;
import cn.hlx.springframework.context.support.ClassPathXmlApplicationContext;
import cn.hlx.springframework.test.bean.IUserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 
 */
public class ApiTest {
    
    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果: " + userService.queryUserInfo());
    }
    
}
