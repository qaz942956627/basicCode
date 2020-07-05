package com.lu.sort;

/**
 * 增加临时变量 让所有需要交换的元素全部右移  然后让最小的元素放到i的位置
 * @author 小卢
 */
public class InsertionSort1_mj<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {

        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}
