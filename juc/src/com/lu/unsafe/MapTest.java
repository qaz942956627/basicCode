package com.lu.unsafe;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 小卢
 */
public class MapTest {

    public static void main(String[] args) {
        //map是这样用的吗? 不是 工作中不用HashMap 并发用ConcurrentHashMap
        //默认等价于什么? new HashMap<>(16,0.75);
        //ConcurrentHashMap原理

        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
