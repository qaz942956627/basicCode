package com.lu.add;

import java.util.concurrent.CountDownLatch;

/**
 * @author 小卢
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 在必须要等待其他任务完成在往下执行代码的时候使用
        CountDownLatch cdl = new CountDownLatch(6);

        for (long i = 0; i < cdl.getCount(); i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"出去一个人");
                // 需要等待执行完毕线程数量-1
                cdl.countDown();
            }).start();
        }

        //等待计数器归零,然后在向下执行
        cdl.await();

        System.out.println("close door");

    }
}
