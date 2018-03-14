package com.patton.start1;

/**
 * Created by Administrator on 2017/8/7.
 */
public class ThreadRunnable implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String args[]){
        Thread th=new Thread(new ThreadRunnable());
        th.start();

    }
}
