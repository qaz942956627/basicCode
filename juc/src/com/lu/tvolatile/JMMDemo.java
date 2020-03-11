package com.lu.tvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @author 小卢
 */
public class JMMDemo {

    /**
     * 不加Volatile 当前线程感知不到变量值的变化 ，程序就会死循环
     * 加Volatile 可以保证可见性
     */
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        num = 1;
        System.out.println(num);
    }
}
