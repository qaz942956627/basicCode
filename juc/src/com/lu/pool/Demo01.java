package com.lu.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors 工具类 三大方法
 */
public class Demo01 {
    public static void main(String[] args) {
        //单个线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 创建一个固定的线程池的大小
        //Executors.newFixedThreadPool(5);
        //可伸缩的
        //Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } finally {
            //线程池使用完毕,程序结束,关闭线程池
            executorService.shutdown();
        }
    }
}
