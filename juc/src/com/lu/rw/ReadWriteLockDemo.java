package com.lu.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁(写锁) 一次只能被一个线程占有
 * 共享锁(读锁) 多个线程可以同时占有
 * ReadWriteLock
 * @author 小卢
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 100; i++) {
            int tmp = i;
            new Thread(() -> {
                myCache.put(tmp+"",tmp);
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 100; i++) {
            int tmp = i;
            new Thread(() -> {
                myCache.get(tmp+"");
            },String.valueOf(i)).start();
        }
    }

}

/**
 * 自定义缓存
 */
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 存,写入
    public void put(String key,Object value) {
        readWriteLock.writeLock().lock();
        try {
            //TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+ "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+ "写入完成" + key);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    //取,读取
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {

            System.out.println(Thread.currentThread().getName()+ "读取" + map.get(key));
            map.get(key);
            System.out.println(Thread.currentThread().getName()+ "读取完毕" + map.get(key));
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}
