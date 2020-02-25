package com.lu.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序调用教程
 *
 * @author 小卢
 */
public class JucSort {
    public static void main(String[] args) {
        DataJucSort data = new DataJucSort();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.print3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread3").start();


    }
}

/**
 * 判断等待,执行业务,通知他人
 */
class DataJucSort {

    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    //设置一个监视器判断该执行那个方法

    private int number = 1;


    public void print1() throws InterruptedException {
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "->1");
            number = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print2() throws InterruptedException {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "->2");
            number = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print3() throws InterruptedException {
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "->3");
            number = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }


}
