package com.dangyou.cache;

import java.util.HashMap;
import java.util.Map;

public class CodeCache {
    private static Map<String,Object> data = new HashMap<>();

    /**
     * 添加
     */
    public static void put(String key,Object value){
        data.put(key,value);
    }
    /**
     * 查询
     */
    public static Object get(String key){
        return data.get(key);
    }
}
