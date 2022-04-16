package com.patton.communication;

/**
 * patton
 */
public class Communication {
    public static void main(String[] args) {
        Person p = new Person();
        Thread thread1 = new Thread(new ProducerThread(p));
        Thread thread2 = new Thread(new ConsumerThread(p));

        thread2.start();
        thread1.start();
    }


}

class ProducerThread implements Runnable {

    private Person p;

    public ProducerThread(Person p) {
        this.p = p;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (p) {
                if (p.name != null) {
                    System.out.println(p.name + ":" + p.age);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p.notify();
                try {
                    p.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class ConsumerThread implements Runnable {
    private Person p;

    public ConsumerThread(Person p) {
        this.p = p;
    }

    @Override
    public void run() {
        boolean b = true;
        while (true) {
            synchronized (p) {
                if (b) {
                    p.name = "a";
                    p.age = "18";
                    b = false;
                } else {
                    p.name = "b";
                    p.age = "60";
                    b = true;
                }
                //System.out.println("设置:"+ p.name + "-" + p.age);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p.notify();
                try {
                    p.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Person {
      String name;
      String age;

    public Person() {
    }

}
