package com.lu.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * @author 小卢
 * 求和计算任务
 * <p>
 * 如何使用ForkJoin
 * 1.ForkJoinPool 通过它来执行
 * 2.计算任务      ForkJoinPool.execute(ForkjoinTask task)
 * ForkjoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //临界值
    private Long temp = 100L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


    // 计算方法
    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            System.out.println(Thread.currentThread().getName()+"正在执行");
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum += i;
            }
            return sum;
        } else {
            // ForkJoin
            // 中间值
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            // 拆分任务,吧任务压入线程队列
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            // 拆分任务,吧任务压入线程队列
            task2.fork();

            return task1.join() + task2.join();
        }
    }

}
