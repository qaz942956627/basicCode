package com.lu.pc;

/**
 * @author 小卢
 */
public class Syn {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"incr").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"decr").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"incr2").start();
        /*new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"decr2").start();*/

    }
}

/**
 * 判断等待,执行业务,通知他人
 */
class Data{
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        while (number!=0) {
            //等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"->"+number);
        //通知其他线程,我+1完毕了
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number==0) {
            //等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"->"+number);
        //通知其他线程,我-1完毕了
        this.notifyAll();
    }
}
