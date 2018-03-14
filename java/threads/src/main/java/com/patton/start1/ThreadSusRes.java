package com.patton.start1;

/**
 * Thread suspend resume 线程的暂停、恢复
 * 对资源占用，如果资源有同步锁，暂停间调用资源会导致死锁
 * Created by patton on 2017/8/11.
 */
public class ThreadSusRes {
    public static void main(String[] args) {
        SusResThread sst=new SusResThread();
        sst.setName("sstThread");
        sst.start();
        try {
            Thread.sleep(1000);
            System.out.println("开始测试"+sst.getI());
            sst.suspend();
            //如果再恢复线程之间使用输出打印，会导致死锁。
            //System.out.println("线程挂起:"+sst.getI());
            Thread.sleep(1000);
            sst.resume();
            System.out.println("线程恢复"+sst.getI());
            System.out.println("线程恢复"+sst.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class SusResThread extends Thread{
    private int i=0;
    @Override
    public void run() {
        super.run();
        while (true){
            //i++;
            //System.out.println()是synchronized的，如果使用如下写法，资源被暂停后会输出会被锁定
            System.out.printf("" + i++);
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
