package com.lu.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 小卢
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        test3();
    }


    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //java.lang.IllegalStateException: Queue full 抛出异常
        //System.out.println(blockingQueue.add("a"));

        System.out.println(blockingQueue.element());

        System.out.println("--------------------");

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        //java.util.NoSuchElementException
        //System.out.println(blockingQueue.element());
        //System.out.println(blockingQueue.remove());
    }

    /**
     * 不抛出异常,给返回值
     */
    public static void test2() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //System.out.println(blockingQueue.offer("a")); 返回false 不抛出异常

        System.out.println(blockingQueue.peek());

        System.out.println("--------------------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //System.out.println(blockingQueue.poll()); 返回null 不抛出异常
    }

    /**
     * 等待,阻塞(一直阻塞)
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d"); 队列没有位置了 会一直阻塞

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take(); 队列没有元素会一直阻塞
    }

    /**
     * 等待,阻塞(等待超时)
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS)); 等待超过两秒就退出

        System.out.println(blockingQueue.peek());

        System.out.println("--------------------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS)); 等待超过两秒就退出
    }
}
