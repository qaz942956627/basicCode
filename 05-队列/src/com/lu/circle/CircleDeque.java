package com.lu.circle;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 数组实现循环双端队列
 * @author 小卢
 */
public class CircleDeque<E> {

    private int size;

    private int front;

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队首入队
     *
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 队尾入队
     *
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    /**
     * 队首出队
     */
    public E deQueueFront() {
        E element = elements[index(0)];
        elements[index(0)] = null;
        front++;
        front = front < elements.length ? front : front - elements.length;
        size--;
        return element;
    }

    /**
     * 队尾出队
     */
    public E deQueueRear() {
        E element = elements[index(size-1)];
        elements[index(size-1)] = null;
        size--;
        return element;
    }

    /**
     * 获取队列的头元素
     *
     * @return
     */
    public E front() {
        return elements[index(0)];
    }

    /**
     * 获取队列的尾元素
     *
     * @return
     */
    public E Rear() {
        return elements[index(size-1)];
    }

    public void clear() {
        //只需要把循环队列中有值的位置设置为null就行 ,不需要遍历数组所有元素把原来就是null的地方从新设置为null
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        //数据清理完之后把size和front的值复原
        size = 0;
        front = 0;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (capacity<=oldCapacity){
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
    }

    private int index(int index) {
        int realIndex = front + index;
        int length = elements.length;
        // index为真实索引位置 如果和大于数组长度证明循环了,需要取模得到真实索引
        if (realIndex < 0) {
            return realIndex + length;
        }
        return realIndex >= length ? realIndex - length : realIndex;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("capacity=").append(elements.length).append(" size=")
                .append(size).append(" front=").append(front).append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(elements[i]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
