package cn.hlx.springframework.test.bean;

import cn.hlx.springframework.stereotype.Component;

import java.util.Random;

/**
 * 
 * 
 * 
 */
@Component("userService")
public class UserService implements IUserService {
    
    private String token;
    
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
    
    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
}
