package com.patton.volatilevar2;

/**
 * Created by Administrator on 2017/8/8.
 */

class Processor extends Thread {
    private  boolean status = true;

    @Override
    public void run() {
        while (status) {
            System.out.println("while print!");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param tmp
     */
    public void setStatus(boolean tmp){
        this.status=tmp;
    }
}

public class ThreadVolatile {
    public static void main(String[] args) {
        Processor p=new Processor();
        p.start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before status changed");
        p.setStatus(false);
        System.out.println("change status false!");
    }
}
