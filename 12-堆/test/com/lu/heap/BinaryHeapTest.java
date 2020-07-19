package com.lu.heap;

import com.lu.heap.printer.BinaryTreeInfo;
import com.lu.heap.printer.BinaryTrees;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    private int a = 1;

    @Test
    void add() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(2);
        heap.add(4);
        heap.add(8);
        heap.add(6);
        heap.add(9);
        heap.add(7);
        heap.add(23);
        heap.add(11);
        BinaryTrees.print(heap);
    }

    private  void testThis() {
        System.out.println(a);
        testAdd(a);
        System.out.println(a);
        Deque<Integer> deque = new LinkedList<>();
    }

    @Test
    void testM() {
        new BinaryHeapTest().testThis();
    }

    private void testAdd(int a) {
        a= a+1;
    }

    @Test
    void cdlTest() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cdl.countDown();
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
        cdl.await();
        System.out.println("success");
    }
}