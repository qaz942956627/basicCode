package com.lu.pool;

import java.util.concurrent.*;

/**
 * 七大参数
 */

/**
 * 拒绝策略
 * new ThreadPoolExecutor.AbortPolicy()  //拒绝策略 银行满了,还有人进来,不处理这个人,直接抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy() //从哪个线程进来的还给哪个线程去处理
 * new ThreadPoolExecutor.DiscardPolicy()  //队列满了,丢掉任务,不会抛出异常
 * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了,尝试去和最早的线程去竞争,如果竞争成功会执行,竞争失败就会放弃任务,也不会抛出异常
 *
 */
public class Demo02 {
    public static void main(String[] args) {

        // 最大线程到底该如何定义
        // 1. cpu密集型 几核心的cpu最大线程数量就是几,可以保证床铺的骁龙最高!
        // 2. IO密集型   判断程序任务中十分耗费io的线程, 最大线程是一般是这个数量的两倍
        //      程序 15个大型任务 io十分占用资源!

        // 获取cpu线程数
        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                //拒绝策略 银行满了,还有人进来,不处理这个人,直接抛出异常
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            //最大承载量: Deque + maximumPoolSize
            for (int i = 0; i < 10; i++) {
                poolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } finally {
            //线程池使用完毕,程序结束,关闭线程池
            poolExecutor.shutdown();
        }
    }
}
