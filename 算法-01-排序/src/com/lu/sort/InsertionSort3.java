package com.lu.sort;

/**
 * 增加临时变量 让所有需要交换的元素全部右移  然后让最小的元素放到i的位置
 * @author 小卢
 */
public class InsertionSort3<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            insert(begin, search(begin));
        }
    }

    public void insert(int source, int target) {
        E tmp = array[source];
        for (int i = source; i > target; i--) {
            array[source] = array[source - 1];
        }
        array[target] = tmp;
    }

    public int search(int index) {

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
