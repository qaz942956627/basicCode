package com.lu.future;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author 小卢
 */
public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*// 没有返回值的 runAsync 异步回调
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "runAsync=>Void");
        });
        System.out.println(1111);
        // 获取阻塞执行的结果
        completableFuture.get();*/

        // 有返回值的supplyAsync 异步回调
        // ajax 成功和失败的回调
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync-> Integer");

            int i = 1 / 0;
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t, u) -> {
            // t 正常的返回结果
            System.out.println("t->" + t);
            // u 错误信息 java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
            System.out.println("u->" + u);
        }).exceptionally((e) -> {
            //失败的回调打印异常信息
            System.out.println(e.getMessage());
            // 可以获取到错误的返回结果
            return -1;
        }).get());
    }
}
