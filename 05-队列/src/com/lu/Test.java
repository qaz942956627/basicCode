package com.lu;

/**
 * @author 小卢
 */
public class Test {

    public static void main(String[] args) {
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
