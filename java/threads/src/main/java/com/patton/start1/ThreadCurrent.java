package com.patton.start1;

/**
 * Created by patton on 2017/8/11.
 */
public class ThreadCurrent {
    public static void main(String[] args) {
        System.out.println("Thread name is :"+Thread.currentThread().getName());
        Mythread mth=new Mythread();
        mth.setName("thread-test");
        mth.start();
    }
}

class Mythread extends Thread{

    public Mythread() {
        System.out.println("Thread name is :"+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Thread name is :"+Thread.currentThread().getName());
    }
}