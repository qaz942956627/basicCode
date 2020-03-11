package com.lu.tvolatile;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不保证原子性
 *
 * @author 小卢
 */
public class VDemo2 {
    //volatile不保证原子性
    // 原子类的integer
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
        //num++; 底层不是一个原子性的操作
        num.getAndIncrement(); // AtomicInteger +1 方法，是用的是acs
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        //jvm最少应该有main线程和jc线程 所以当前线程数>2就证明还有线程没执行完
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ":" + num);
    }
}
