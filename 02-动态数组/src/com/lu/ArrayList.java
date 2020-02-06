package com.lu;

import java.util.Arrays;

/**
 * @author 小卢
 */
public class ArrayList<E> {

    private int size;

    private E[] elements;

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }
    public ArrayList(int capacity){
        this.elements = (E[]) (capacity < DEFAULT_CAPACITY ? new Object[DEFAULT_CAPACITY] : new Object[capacity]);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean contains(E element){
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(E element){
        add(size,element);
    }

    public E get(int index){
        checkRange(index);
        return elements[index];
    }



    public E set(int index, E element){
        checkRange(index);
        elements[index] = element;
        return element;
    }

    public void add(int index,E element){
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        if (index==size){
            this.elements[size] = element;
        }else {
            for (int i = size; i > index; i++) {
                elements[i] = elements[i-1];
            }
            elements[index] = element;
        }
        this.size++;
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

    public E remove(int index){
        checkRange(index);
        E element = elements[index];
        for (int i = index; i < size-1; i++) {
            elements[i] = elements[i+1];
        }
        //移动完所有元素让最后一个元素的地址值为空,方便gc回收
        elements[size--] = null;
        return  element;
    }

    public int indexOf(E element){
        if (element==null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size ; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    public void clear(){

        //在设置size=0之前 将所有元素的地址值设置为null 解除内存占用
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size){
            String msg = "请求下标为:" + index + "最大下标为:" + size;
            throw new IndexOutOfBoundsException(msg);
        }
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            String msg = "请求下标为:" + index + "最大下标为:" + size;
            throw new IndexOutOfBoundsException(msg);
        }
    }
}
