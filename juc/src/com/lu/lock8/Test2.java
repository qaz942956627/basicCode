package com.lu.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 3 增加了一个普通方法,hello,先执行那个
 * 4 两个对象两个同步方法,是先执行打电话还是发短信
 * @author 小卢
 */
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();

        new Thread(() -> {
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.hello();
        },"B").start();
    }


}

/**
 * 发短信延迟4秒,还是先发短信在打电话
 */
class Phone2{

    /**
     * synchronized 锁的对象是方法的调用者!
     * 两个方法用的是同一个锁,谁先拿到谁先执行
     */
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void call() {
        System.out.println("call");
    }

    public void hello() {
        System.out.println("hello");
    }
}
