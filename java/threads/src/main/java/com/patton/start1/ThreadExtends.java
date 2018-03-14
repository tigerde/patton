package com.patton.start1;

/**
 * Created by Administrator on 2017/8/7.
 */
public class ThreadExtends extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("start a thread by extends Thread!");
    }

    public static void main(String args[]){
        ThreadExtends te= new ThreadExtends();
        te.start();
    }
}
