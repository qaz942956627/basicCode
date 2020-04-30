package com.lu;

import com.lu.list.LinkedList;
import com.lu.list.List;

/**
 * @author 小卢
 */
public class Queue<E> {

    private List<E> list = new LinkedList();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入队
     * @param element
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E front() {
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }
}
