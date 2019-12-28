package com.lu;

public class ArrayList {

    private int size;

    private int[] elements;

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }
    public ArrayList(int capacity){
        this.elements = capacity < DEFAULT_CAPACITY ? new int[DEFAULT_CAPACITY] : new int[capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean contains(int element){
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int element){
        this.elements[this.size] = element;
        this.size++;
    }

    public int get(int index){
        if (index<0||index>=size){
            String msg = "请求下标为:"+index+"最大下标为:"+size;
            throw new IndexOutOfBoundsException(msg);
        }
        return elements[index];
    }

    public int set(int index,int element){
        if (index<0||index>=size){
            String msg = "请求下标为:"+index+"最大下标为:"+size;
            throw new IndexOutOfBoundsException(msg);
        }
        elements[index] = element;
        return element;
    }

    public void add(int index,int element){


    }

    public int remove(int index){
        if (index<0||index>=size){
            String msg = "请求下标为:"+index+"最大下标为:"+size;
            throw new IndexOutOfBoundsException(msg);
        }
        int element = elements[index];
        for (int i = index; i < size-1; i++) {
            elements[i] = elements[i+1];
        }
        size--;
        return  element;
    }

    public int indexOf(int element){
        for (int i = 0; i < size - 1; i++) {
            if (elements[i]==element) {
                return i;
            }
        }
        return -1;
    }

    public void clear(){
        size = 0;
    }
}
