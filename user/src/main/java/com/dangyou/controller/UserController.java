package com.dangyou.controller;


import com.dangyou.cache.CodeCache;
import com.dangyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sendCode")
    public Map<String,Object> sendCode(@RequestParam long phone){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("status",0);
        result.put("data",userService.sendCode(phone));
        return result;
    }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestParam long phone,@RequestParam String code){
        return userService.login(phone,code);
    }
}
