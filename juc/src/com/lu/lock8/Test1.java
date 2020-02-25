package com.lu.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author 小卢
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendSms();
        },"A").start();

        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.call();
        },"B").start();
    }


}

/**
 * 发短信延迟4秒,还是先发短信在打电话
 */
class Phone{

    /**
     * synchronized 锁的对象是方法的调用者!
     * 两个方法用的是同一个锁,谁先拿到谁先执行
     */
    public synchronized void sendSms() {
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void call() {
        System.out.println("call");
    }
}
