package com.huntor.tools;

/**
 * Created by liuyang on 2017/8/21.
 */
public class Demo{
    public static void main(String[] args){
//        I want to tell you:
        int wolf = 0xff6fddab,rabbit=0x005f7db6,razzit=0x00000000;
        razzit = wolf & rabbit;
        System.out.println(razzit);
    }
}
