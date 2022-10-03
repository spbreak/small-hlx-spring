package cn.hlx.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    
    private static Map<String, String> hashMap = new HashMap<>();
    
    static {
        hashMap.put("10001", "小黄哥");
        hashMap.put("10002", "十杯水");
        hashMap.put("10003", "啊发");
    }
    
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
