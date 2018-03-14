package com.patton.start1;

/**
 * Created by patton on 2017/8/11.
 */
public class ThreadStop {
    public static void main(String[] args) {
        //deprecated 暴力停止，如果有资源锁可能会导致未释放而出现问题
        SynchronizedObject so=new SynchronizedObject();
        System.out.println("name:"+so.getName()+" pwd:"+so.getPwd());
        StopThread st=new StopThread(so);
        st.setName("stopThread");
        st.start();
        System.out.println("stopThread stop");
        st.stop();


        //强制stop导致资源修改出问题，数据不一致








        //逻辑停止线程
        LogicThread lt=new LogicThread();
        lt.setName("LogicThread");
        lt.start();
        lt.setStatus(false);
        System.out.println("LogicThread stop");

        //执行interrupt 方式中断线程
        /*InterruptThread it=new InterruptThread();
        it.setName("InterruptThread");
        it.start();
        it.interrupt();
        System.out.println("InterruptThread:" + it.isInterrupted());
        System.out.println("InterruptThread:" + it.isInterrupted());
        System.out.println("InterruptThread interrupt");
        System.out.println("InterruptThread "+it.isInterrupted());*/

        //在sleep状态下的thread如果进行interrupt thread的sleep会抛
        // 出异常，然后清除interrupt状态为false
        // 使用return停止线程
        InterruptSleepThread ist=new InterruptSleepThread();
        ist.setName("InterruptSleepThread");
        ist.start();
        ist.interrupt();
        System.out.println("InterruptSleepThread:" + ist.isInterrupted());
        System.out.println("InterruptSleepThread:" + ist.isInterrupted());
        System.out.println("InterruptSleepThread interrupt");
        System.out.println("InterruptSleepThread "+ist.isInterrupted());

    }
}

class StopThread extends Thread{
    private SynchronizedObject so=null;
    public StopThread(SynchronizedObject so) {
        this.so=so;
    }

    @Override
    public void run() {
        super.run();
        so.printObject("b","cc");
    }
}

class InterruptThread extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            try {
                if (this.isInterrupted()){
                    break;
                }
                Thread.sleep(1000);
                System.out.println("Thread is Running"+this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class InterruptSleepThread extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("Thread is Running"+this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(this.getName()+": is interrupted stop");
                return ;
            }
        }
    }
}

class LogicThread extends Thread{
    private volatile boolean status=true;

    @Override
    public void run() {
        super.run();
        while (status){
            try {
                Thread.sleep(1000);
                System.out.println("Thread is Running"+this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

class SynchronizedObject{
    private String name="aa";
    private String pwd="pwd";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public SynchronizedObject() {
    }

    synchronized public void printObject(String username,String password){
        try {
            this.name=username;
            Thread.sleep(100000);
            this.pwd=password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
