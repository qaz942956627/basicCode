package com.lu.heap;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 小卢
 */
public class BinaryHeap<E> implements Heap<E> {

    private int size;

    private E[] elements;

    private Comparator<E> comparator;

    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(){
        this(null);
    }
    public BinaryHeap(Comparator<E> comparator){
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.fill(elements,null);
    }

    @Override
    public void add(E element) {

        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size);

    }

    /**
     * 添加完元素维持二叉堆性质
     * @param index
     */
    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            if (compare(parentIndex, index) > 0) {
                swap(index, parentIndex);
                siftUp(parentIndex);
            } else {
                return;
            }
        }
    }

    @Override
    public E get() {
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    /**
     * 确保有足够容量来存放数据
     * 如果容量不够将数组容量扩充诶当前数组的1.5倍
     * 并将之前的元素都copy进新的数组
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (capacity<=oldCapacity){
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        elements = Arrays.copyOf(elements,newCapacity);
    }

    private void emptyCheck() {
        if (size==0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private void swap(int i1, int i2) {
        E tmp = elements[i1];
        elements[i1] = elements[i2];
        elements[i2] = tmp;
    }

    private int compare(int i1, int i2) {
        return cmpElement(elements[i1], elements[i2]);
    }

    private int cmpElement(E e1, E e2) {
        return comparator != null ? comparator.compare(e1, e2) : ((Comparable<E>) e1).compareTo(e2);
    }
}
