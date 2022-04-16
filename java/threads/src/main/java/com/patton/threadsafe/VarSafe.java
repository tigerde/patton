package com.patton.threadsafe;

/**
 * Created by Administrator on 2017/8/10.
 */
class VarSafe extends Thread{
    private int count=10;
    private synchronized void reduce(){
        count--;
        System.out.println("由线程"+this.currentThread().getName()+"计算："+count);
    }
    @Override
    public void run() {
        super.run();
        //判断时未对count进行锁定，导致reduce时可能存在抢锁情况，所以会有reduce处理count数据与判断时count数据不一致情况。
        while (count>0){
            //System.out.println("由线程"+this.currentThread().getName()+"计算："+count);
            reduce();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VarSafe p=new VarSafe();
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
