package com.patton.start1;

/**
 * yield方法放弃当前的CPU资源，将它让给其它的任务去占用CPU执行时间。
 * 放弃的时间长短不确定，可能刚刚放弃，马上又获得时间片。
 * Created by patton on 2017/8/17.
 */
public class ThreadYield extends Thread{

    @Override
    public void run() {
        super.run();
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            //cpu资源让出
            //Thread.yield();
            count=count+i+1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时："+(endTime-beginTime)+"毫秒！");
    }

    public static void main(String[] args) {
        ThreadYield ty = new ThreadYield();
        ty.start();
    }
}
