package com.patton.synchro3;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

/**
 * Created by patton on 2017/8/18.
 */
public class Worker {
    private Random random = new Random();

    private Object object1 = new Object();
    private Object object2 = new Object();


    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    private void stageOne() {
        synchronized (object1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }

    }

    private void stageTwo() {
        synchronized (object2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken:" + (end - start));
        System.out.println("List1:" + list1.size() + ";list2:" + list2.size());
    }

}
