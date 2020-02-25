package com.lu.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 小卢
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        /**
         * 集齐七颗龙珠,召唤神龙
         */
        // 召唤神龙的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("召唤神龙!!!!!!!!");
        });

        for (int i = 0; i < 7; i++) {
            //变量的作用域需要定义成final 好像1.8之后不用final修饰也行但是不可以修改值,实质上还是final 只是不需要明确标识出来
            int tmp = i;
            //tmp = 0;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"找到一颗龙珠-->"+tmp);

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"成功召唤神龙,回家吃饭!!!");
            }).start();
        }
    }
}
