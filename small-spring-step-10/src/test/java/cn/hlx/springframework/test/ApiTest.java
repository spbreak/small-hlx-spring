package cn.hlx.springframework.test;

import cn.hlx.springframework.context.support.ClassPathXmlApplicationContext;
import cn.hlx.springframework.test.event.CustomEvent;
import org.junit.Test;


public class ApiTest {
    
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了"));
        
        applicationContext.registerShutdownHook();
    }
}
