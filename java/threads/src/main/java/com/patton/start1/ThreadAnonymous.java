package com.patton.start1;

/**
 * Created by Administrator on 2017/8/7.
 */
public class ThreadAnonymous {
    public static void main(String args[]){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" anonymous");
            }
        });
        t.start();

    }


}
