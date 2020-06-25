package com.lu.sort;

/**
 * @author 小卢
 */
public class SelectionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                // 核心点 一直让当前最小的元素和下标为j的元素进行比较 找出最小元素下标
                /*if (array[min] > array[j]) {
                    min = j;
                }*/
                if (cmpElements(array[min], array[j]) < 0) {
                    min = j;
                }
            }
            //如果最小元素就是i 则不需要自己和自己交换
            if (min != i) {
                swap(min,i);
                /*E tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;*/
            }
        }
    }
}
