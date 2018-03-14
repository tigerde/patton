package com.patton.ThreadJoin;

/**
 * 验证；
 * Created by patton on 2017/8/11.
 */
public class Worker {
    private int count=0;

    public static void main(String[] args) {
    Worker worker=new Worker();
        worker.dowork();
    }

    private synchronized void increment(String name) throws InterruptedException {
        count++;
        Thread.sleep(1000);
        System.out.println("Thread in progress:"+name+" and count is:"+count);
    }

    public void dowork(){
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        increment(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"thread1");

        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        increment(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"thread2");

        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.printf("Count is :"+count);
        }


    }
}
