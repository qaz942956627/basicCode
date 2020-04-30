package com.lu.list;

/**
 * @author 小卢
 */
public abstract class AbstractList<E> implements List<E>{

    protected int size;

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element){
        add(size,element);
    }


    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size){
            String msg = "请求下标为:" + index + "最大下标为:" + size;
            throw new IndexOutOfBoundsException(msg);
        }
    }

    protected void checkRange(int index) {
        if (index < 0 || index >= size) {
            String msg = "请求下标为:" + index + "最大下标为:" + size;
            throw new IndexOutOfBoundsException(msg);
        }
    }
}
