package com.lu.demo01;

/**
 * @author 小卢
 */
public class SaleTicketSyn {

    public static void main(String[] args) {
        // 并发,多个线程同时操作同一个资源类,把资源类丢入线程
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"C").start();

    }
}

/**
 * 线程就是一个单独的资源类,没有任何附属操作
 * 资源类 oop
 */
class Ticket {
    //属性,方法

    private int number = 50;

    /**
     * 卖票
     * synchronized:本质就是队列,锁
     * 要求线程排队
     */
    public synchronized void sale() {
        if (number>0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + number-- + "张票,还剩" + number + "张票");
        }
    }

}