package com.lu.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java.util.ConcurrentModificationException 并发修改异常
 * @author 小卢
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new CopyOnWriteArrayList<>();

        /**
         * 解决方案:
         * 1.List<String> list = new Vector<>()
         * 2.Collections.synchronizedList(new ArrayList<>())
         * 3.new CopyOnWriteArrayList<>()
         *      CopyOnWrite 写入时复制 COW 计算机程序设计灵药的一种优化策略
         *      多线程调用的时候list,读取的时候,固定的,写入(覆盖)
         *      在写入的时候避免覆盖造成数据问题 写入的时候复制一份数据,写入之后在插入进去
         *      读写分离
         *      CopyOnWriteArrayList 比 Vector 好在哪里
         */
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
