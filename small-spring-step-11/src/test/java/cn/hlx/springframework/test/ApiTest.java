package cn.hlx.springframework.test;

import cn.hlx.springframework.aop.AdvisedSupport;
import cn.hlx.springframework.aop.MethodMatcher;
import cn.hlx.springframework.aop.TargetSource;
import cn.hlx.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.hlx.springframework.aop.framework.Cglib2AopProxy;
import cn.hlx.springframework.aop.framework.JdkDynamicAopProxy;
import cn.hlx.springframework.aop.framework.ReflectiveMethodInvocation;
import cn.hlx.springframework.test.bean.IUserService;
import cn.hlx.springframework.test.bean.UserService;
import cn.hlx.springframework.test.bean.UserServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * 
 * 
 */
public class ApiTest {
    
    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.hlx.springframework.test.bean.UserService.*(..))");
        
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");
        
        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }
    
    @Test
    public void test_start_try_finally() {
        System.out.println("test_start_try_finally:" + test_try_finally());
    }
    
    public int test_try_finally() {
        int i = 1;
        try {
            i ++; 
            System.out.println("try:" + i);
            return i;
        } finally {
            i ++;
            System.out.println("finally:" + i);
        }        
    }
    
    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.hlx.springframework.test.bean.IUserService.*(..))"));
        
        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果: " + proxy_jdk.queryUserInfo() + "\r\n");
        
        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用 
        System.out.println("测试结果: " + proxy_cglib.register("木木"));
    }
    
    @Test
    public void test_proxy_class() {
        IUserService userService = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserService.class}, (proxy, method, args) -> "您被代理了");
        String result = userService.queryUserInfo();
        System.out.println("测试结果: " + result);
    }
    
    @Test
    public void test_proxy_method() {
        // 目标对象(可以替换成任何的目标对象)
        Object targetObj = new UserService();
        
        // AOP 代理
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* cn.hlx.springframework.test.bean.IUserService.*(..))");
            
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin By AOP");
                            System.out.println("方法名称: " + invocation.getMethod().getName());
                            System.out.println("方法耗时: " + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });
        
        String result = proxy.queryUserInfo();
        System.out.println("测试结果: " + result);
    }
}
