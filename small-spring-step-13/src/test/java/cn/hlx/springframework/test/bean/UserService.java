package cn.hlx.springframework.test.bean;

import java.util.Random;

/**
 * 
 * 
 * 
 */
public class UserService implements IUserService {
    
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小黄哥, 100001, 广州";
    }
    
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户: " + userName + " success!";
    }
    
}
