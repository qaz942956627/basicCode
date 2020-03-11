package com.lu.single;

/**
 * 饿汉式单例
 * @author 小卢
 */
public class Hungry {

    //可能会浪费空间
    private byte[] data1 = new byte[1024 * 1024];
    private byte[] data2 = new byte[1024 * 1024];
    private byte[] data3 = new byte[1024 * 1024];
    private byte[] data4 = new byte[1024 * 1024];

    private Hungry() {

    }

    private final static Hungry HUNGRY = new Hungry();

    public Hungry getInstance() {
        return HUNGRY;
    }
}
