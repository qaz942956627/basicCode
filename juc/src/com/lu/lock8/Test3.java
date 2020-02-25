package com.lu.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 3 增加了一个普通方法,hello,先执行那个
 * 4 两个对象两个同步方法,是先执行打电话还是发短信
 * @author 小卢
 */
public class Test3 {
    public static void main(String[] args) {
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        new Thread(() -> {
            phone1.sendSms();
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
class Phone3{

    /**
     * synchronized 锁的对象是方法的调用者!
     * static 静态方法
     * 类一家在就有了!锁的是class(全局唯一)
     */
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public static synchronized void call() {
        System.out.println("call");
    }

}
