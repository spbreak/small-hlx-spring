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
import cn.hlx.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.hlx.springframework.test.common.MyBeanPostProcessor;
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
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        
        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        
        // 3. BeanDefinition 加载完成 & Bean实例化之前, 修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        
        // 4. Bean实例化之后, 修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);
        
        // 5. 获取 Bean 对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果: " + result);
    }
    
    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        
        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果: " + result);
    }
    
}
