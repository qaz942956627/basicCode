package com.lu.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 小卢
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 线程数量: 停车位,有几个位置  限流的时候可以使用到
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                // acquire 获得
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //release 释放  让出资源给其他线程使用
                    semaphore.release();
                }
            }).start();
        }
    }
}
