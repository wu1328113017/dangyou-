package com.dangyou.util;

import java.util.Random;

public class MakeCode {
    /**
     * 生成验证码
     * @return
     */
    public static String makeCode(int le){
        StringBuffer str = new StringBuffer();
        for(int i=0;i<le;i++){
            str.append((int)(Math.random()*10));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeCode(6));
    }
}
