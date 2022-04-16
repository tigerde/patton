package com.patton.start1;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * Created by patton on 2017/8/11.
 */
public class ThreadID {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getId());
    }
}
