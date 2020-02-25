package com.lu.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 1 一个静态的同步方法,一个普通的同步方法,一个对象,先打印什么
 * 2 一个静态的同步方法,一个普通的同步方法,连个对象,先打印什么
 * @author 小卢
 */
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();

        new Thread(() -> {
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.call();
        },"B").start();
    }


}

/**
 * 发短信延迟4秒,还是先发短信在打电话
 */
class Phone4{

    /**
     * synchronized 锁的对象是方法的调用者!
     * static 静态方法
     * 类一加载就有了!锁的是class(全局唯一)
     * 锁的是类模板
     */
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    /**
     * 锁的是方法调用者
     */
    public synchronized void call() {
        System.out.println("call");
    }

}
