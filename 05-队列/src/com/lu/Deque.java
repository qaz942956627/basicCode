package com.lu;

import com.lu.list.LinkedList;
import com.lu.list.List;

/**
 * @author 小卢
 */
public class Deque<E> {

    private List<E> list = new LinkedList();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 队首入队
     *
     * @param element
     */
    public void enQueueFront(E element) {
        list.add(0, element);
    }

    /**
     * 队尾入队
     *
     * @param element
     */
    public void enQueueRear(E element) {
        list.add(element);
    }

    /**
     * 队首出队
     */
    public E deQueueFront() {
        return list.remove(0);
    }

    /**
     * 队尾出队
     */
    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取队列的头元素
     *
     * @return
     */
    public E front() {
        return list.get(0);
    }

    /**
     * 获取队列的尾元素
     *
     * @return
     */
    public E Rear() {
        return list.get(list.size() - 1);
    }

    public void clear() {
        list.clear();
    }
}
