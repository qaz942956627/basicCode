package com.lu.heap;

import com.lu.heap.printer.BinaryTreeInfo;
import com.lu.heap.printer.BinaryTrees;
import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 小卢
 */
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(){
        this(null);
    }
    public BinaryHeap(Comparator<E> comparator){
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
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
        elements[size] = element;
        siftUp(size);
        size++;

    }

    /**
     * 添加完元素维持二叉堆性质
     * @param index
     */
    private void siftUp(int index) {
        /*while (index > 0) {
            // 完全二叉树计算父节点索引
            int parentIndex = (index - 1) >> 1;
            // 如果插入节点大于父节点则交换位置
            if (compare(index, parentIndex) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                return;
            }
        }*/

        E element = elements[index];
        while (index > 0) {
            // 完全二叉树计算父节点索引
            int parentIndex = (index - 1) >> 1;
            // 如果插入节点大于父节点则父节点的值覆盖子节点,不需要交换
            E p = elements[parentIndex];
            if (cmpElement(element, p) > 0) {
                elements[index] = p;
                index = parentIndex;
            } else {
                // 走到这里代表本次插入的element不是最大的,使用break是因为还需要把本次插入的元素赋值进去
                break;
            }
        }
        elements[index] = element;
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();
        E removeElement = elements[0];
        E element = elements[size - 1];
        elements[0] = element;
        elements[size - 1] = null;
        size--;
        siftDown(0);
        return removeElement;
    }

    /**
     * 让index位置的元素下滤
     * @param index
     */
    private void siftDown(int index) {
        int half = size >> 1;
        /**
         * 根据完全二叉树性质可以推出来,
         * 第一个叶子节点的索引 == 非叶子节点的数量
         * index < 第一个叶子节点的索引
         * 必须保证index的位置是非叶子节点
         */
        while (index < half) {

        }

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

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int)node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int)node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int)node];
    }

}
