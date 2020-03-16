package com.lu;

import java.util.concurrent.TimeUnit;

/**
 * 在没有同步的情况下共享变量
 *
 * @author 小卢
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println(Thread.currentThread().getName()+"   ->    yield");
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+"   ->number:"+number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        TimeUnit.MICROSECONDS.sleep(1);
        number = 42;
        System.out.println(Thread.currentThread().getName()+"   ->    number = 42");
        TimeUnit.MICROSECONDS.sleep(1);
        ready = true;
        System.out.println(Thread.currentThread().getName()+"   ->    ready = true");
    }
}
