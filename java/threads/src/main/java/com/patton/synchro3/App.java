package com.patton.synchro3;


/**
 * Created by patton on 2017/8/18.
 */
public class App {

    public static void main(String[] args) {
        WorkerMethodsSynchronized ws = new WorkerMethodsSynchronized();
        ws.main();

        Worker wk = new Worker();
        wk.main();
    }
}
