package com.lu.forkjoin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

/**
 * @author 小卢
 */
public class ImportTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test2();
    }


    public static void test2() throws ExecutionException, InterruptedException {
        List<Integer> integers = new ArrayList<>(10000);

        for (int i = 0; i < 10000; i++) {
            integers.add(i);
        }
        LocalDateTime start = LocalDateTime.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ImportDemo forkJoinDemo = new ImportDemo(integers);
        forkJoinPool.submit(forkJoinDemo);
        //阻塞当前线程知道任务都执行完
        boolean b = forkJoinPool.awaitTermination(2000000000, TimeUnit.SECONDS);


        LocalDateTime end = LocalDateTime.now();
        System.out.println("结束时间:" + end);
        System.out.println("时间" + (Duration.between(start, end).toMillis()));
    }

}
