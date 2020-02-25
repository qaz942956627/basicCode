package com.lu.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 小卢
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 启动线程的方式只有 Thread.start();
         * Thread里面只接受Runnable接口的实现类
         * new Thread(new Runnable() ).start();
         * FutureTask<V>是Runnable接口的实现类并且FutureTask<V>有一个接受一个Callable的构造函数
         * new Thread(new FutureTask( Callable ) )
         * 这样就使得callable和thread关联起来
         */
        MyThread thread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(thread);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();
        //这个get方法可能会产生阻塞!一般来把他放到最后 或者使用异步通信
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}
