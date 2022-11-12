package cn.hlx.springframework.test.bean;

import cn.hlx.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {
    
    private static Map<String, String> hashMap = new HashMap<>();
    
    static {
        hashMap.put("10001", "小黄哥, 北京, 朝阳");
        hashMap.put("10002", "大刀, 广州, 番禺");
        hashMap.put("10003", "国庆, 北京, 朝阳");
    }
    
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
    
}
