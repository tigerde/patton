package com.patton.threadsafe;

/**
 * Created by Administrator on 2017/8/10.
 */
public class Processor extends Thread {
    private int count=10;

    @Override
   synchronized public void run() {
        super.run();
        count--;
        System.out.println("由线程"+this.currentThread().getName()+"计算："+count);
       }

    public static void main(String[] args) {
        Processor p=new Processor();
        Thread t1=new Thread(p,"a");
        Thread t2=new Thread(p,"b");
        Thread t3=new Thread(p,"c");
        Thread t4=new Thread(p,"d");
        Thread t5=new Thread(p,"e");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}


