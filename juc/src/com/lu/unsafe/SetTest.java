package com.lu.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 和list一样
 * @author 小卢
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //Collections.synchronizedSet(new HashSet<>());
        //new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }
}
