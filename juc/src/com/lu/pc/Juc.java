package com.lu.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 小卢
 */
public class Juc {
    public static void main(String[] args) {
        DataJuc data = new DataJuc();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"incr").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"decr").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"incr2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"decr2").start();

    }
}

/**
 * 判断等待,执行业务,通知他人
 */
class DataJuc{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number!=0) {
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"->"+number);
            //通知其他线程,我+1完毕了
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number==0) {
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"->"+number);
            //通知其他线程,我-1完毕了
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
