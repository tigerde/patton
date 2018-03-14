package com.patton.start1;

/**
 * Created by patton on 2017/8/11.
 */
public class ThreadIsAlive {
    public static void main(String[] args) {
        LiveThread mth=new LiveThread();
        mth.setName("thread-test");
        mth.start();
        for (int i = 0; i <11 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(mth.isAlive()+"");
        }


    }
}
class LiveThread extends Thread{
   
    @Override
    public void run() {
        super.run();
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}