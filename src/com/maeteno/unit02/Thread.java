package com.maeteno.unit02;

public class Thread {

    final static Object object = new Object();

    public static void main(String[] args) {
        Runnable demo = new Runnable() {
            @Override
            public void run() {

                synchronized (object) {
                    try {
                        java.lang.Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("匿名类实现");
                    object.notify();
                }
            }
        };

        Runnable demo2 = () -> System.out.println("lambda");

        new java.lang.Thread(new Demo3()).start();
        new java.lang.Thread(demo).start();
        new java.lang.Thread(demo2).start();
    }

    static class Demo3 implements Runnable {
        @Override
        public void run() {

            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    java.lang.Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Demo3");
            }
        }
    }
}


