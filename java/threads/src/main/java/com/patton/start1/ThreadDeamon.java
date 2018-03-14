package com.patton.start1;

/**
 * Java有两种线程一种用户线程，一种守护线程。
 * 守护线程
 * Created by patton on 2017/8/17.
 */
public class ThreadDeamon extends Thread {
    private int i = 0;

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ThreadDeamon td = new ThreadDeamon();
            td.setDaemon(true);
            td.start();
            Thread.sleep(1000);
            System.out.println("主线程退出，thread线程停止打印");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
