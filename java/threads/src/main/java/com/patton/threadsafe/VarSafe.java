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
        while (count>0){
            reduce();
        }
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
