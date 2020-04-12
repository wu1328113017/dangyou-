package com.dangyou.service.impl;

import com.dangyou.cache.CodeCache;
import com.dangyou.entity.User;
import com.dangyou.mapper.UserMapper;
import com.dangyou.service.UserService;
import com.dangyou.util.MakeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Map<String,Object> sendCode(long phone) {
        Map<String,Object> result = new HashMap<>();
        String code = MakeCode.makeCode(6);
        result.put("code", code);
        CodeCache.put("phone",phone);
        CodeCache.put("code",code);
        return result;
    }

    @Override
    public Map<String, Object> login(long phone, String code) {
        Map<String,Object> result = new HashMap<>();
        Long c_phone = (Long) CodeCache.get("phone");
        String c_code = (String) CodeCache.get("code");
        if(phone == c_phone && code.equals(c_code)){
            User user = new User();
            user.setPhone(phone);
            if(userMapper.selectLength(user) == 0){
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                userMapper.insert(user);
            }
            result.put("status",0);
        }else{
            result.put("status",1);
            result.put("message","手机号码或验证码不正确");
        }
        return result;
    }
}
