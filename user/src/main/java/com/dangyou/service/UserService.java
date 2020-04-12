package com.dangyou.service;


import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    /**
     * 发送验证码
     */
    Map<String,Object> sendCode(long phone);
    /**
     * 登录/注册
     */
    Map<String,Object> login(long phone,String code);
}
