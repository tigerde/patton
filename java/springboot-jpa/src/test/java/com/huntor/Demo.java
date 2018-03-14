package com.huntor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyang on 2017/7/12.
 */
public class Demo {
    public static void main(String[] args){
        Map map=new HashMap<>();
        map.put("r",1111);
        map.put("r",2222);
        map.put("r",3333);
        map.put("r",4444);
        System.out.print(map.toString());
    }
}
