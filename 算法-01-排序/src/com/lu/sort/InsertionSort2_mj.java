package com.lu.sort;

/**
 * 增加临时变量 让所有需要交换的元素全部右移  然后让最小的元素放到i的位置
 * @author 小卢
 */
public class InsertionSort2_mj<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {

        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            E v = array[cur];
            while (cur > 0 && cmpElements(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }
}
