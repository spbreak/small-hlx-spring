package cn.hlx.springframework.test;

import cn.hlx.springframework.beans.PropertyValue;
import cn.hlx.springframework.beans.PropertyValues;
import cn.hlx.springframework.beans.factory.config.BeanDefinition;
import cn.hlx.springframework.beans.factory.config.BeanReference;
import cn.hlx.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.hlx.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.hlx.springframework.context.support.ClassPathXmlApplicationContext;
import cn.hlx.springframework.core.io.DefaultResourceLoader;
import cn.hlx.springframework.core.io.Resource;
import cn.hlx.springframework.test.bean.UserDao;
import cn.hlx.springframework.test.bean.UserService;
import cn.hutool.core.io.IoUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ApiTest {
    
    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        
        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果: " + result);
        
        System.out.println("ApplicationContextAware: " + userService.getApplicationContext());
        System.out.println("BeanFactoryAware: " + userService.getBeanFactory());
    }
    
}
