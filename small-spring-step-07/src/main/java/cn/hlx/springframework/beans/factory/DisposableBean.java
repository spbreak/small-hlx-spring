package cn.hlx.springframework.beans.factory;

public interface DisposableBean {
    
    void destroy() throws Exception;
    
}
