package com.lu.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 小卢
 */
public class SaleTicketLock {

    public static void main(String[] args) {
        // 并发,多个线程同时操作同一个资源类,把资源类丢入线程
        TicketLock ticket = new TicketLock();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();

    }
}

/**
 * 线程就是一个单独的资源类,没有任何附属操作
 * 资源类 oop
 */
class TicketLock {
    //属性,方法

    private int number = 50;

    private Lock lock = new ReentrantLock();

    /**
     * 卖票
     * synchronized:本质就是队列,锁
     * 要求线程排队
     */
    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + "卖出了第" + number-- + "张票,还剩" + number + "张票");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}