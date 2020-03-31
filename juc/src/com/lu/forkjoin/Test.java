package com.lu.forkjoin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author 小卢
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test2();
    }

    public static void test1() {
        long sum = 0L;
        long start = System.currentTimeMillis();
        for (long i = 1; i <= 10_0000_0000L; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间"+(end-start));
    }

    //使用ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("开始时间:"+start);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1L, 1_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        Long sum = submit.get();
        LocalDateTime end = LocalDateTime.now();
        System.out.println("结束时间:"+end);
        System.out.println("sum="+sum+"时间"+(Duration.between(start,end).toMillis()));
    }

    public static void test3() {
        long start = System.currentTimeMillis();
        //Stream并行流  parallel 并行的意思
        //long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().sum();
        //long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0L,(l1,l2)-> Long.sum(l1,l2));
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(2L,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间"+(end-start));
    }
}
