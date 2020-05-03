package com.lu;

import com.lu.circle.CircleDeque;
import com.lu.circle.CircleQueue;

/**
 * @author 小卢
 */
public class Test {

    public static void main(String[] args) {
        circleDequeTest();
    }

    private static void circleDequeTest() {
        CircleDeque<Integer> queue = new CircleDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i+100);
        }
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }
        queue.enQueueFront(11);
        queue.enQueueFront(12);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueFront());
        }
    }

    private static void circleQueueTest() {
        CircleQueue<Integer> queue = new CircleQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }
        for (int i = 15; i < 20; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }

    private static void queueTest() {
    /*Queue<Integer> queue = new Queue<>();
    queue.enQueue(1);
    queue.enQueue(2);
    queue.enQueue(3);
    queue.enQueue(4);

    while (!queue.isEmpty()) {
        System.out.println(queue.deQueue());
    }*/

        Deque<Integer> deque = new Deque<>();
        /*deque.enQueueFront(1);
        deque.enQueueFront(2);
        deque.enQueueFront(3);
        deque.enQueueFront(4);
        deque.enQueueFront(5);*/
        deque.enQueueRear(1);
        deque.enQueueRear(2);
        deque.enQueueRear(3);
        deque.enQueueRear(4);
        deque.enQueueRear(5);

        while (!deque.isEmpty()) {
            System.out.println(deque.deQueueFront());
        }
    }
}
