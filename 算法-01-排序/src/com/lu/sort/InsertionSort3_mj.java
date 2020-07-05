package com.lu.sort;

/**
 * 增加临时变量 让所有需要交换的元素全部右移  然后让最小的元素放到i的位置
 * @author 小卢
 */
public class InsertionSort3_mj<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {

        for (int begin = 1; begin < array.length; begin++) {
            //找到待插入位置
            int insertIndex = search(begin);
            //备份待插入元素
            E value = array[begin];
            for (int i = begin; i > insertIndex; i--) {
                array[i] = array[i - 1];
            }
            array[insertIndex] = value;
        }
    }

    private int search(int index) {
        int begin = 0;
        int end = index;
        int mid = 0;
        while (begin < end) {
            mid = (begin + end) >> 1;
            if (cmpElements(array[index], array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
