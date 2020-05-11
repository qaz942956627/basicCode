package com.lu;

/**
 * @author 小卢
 */
public class SelectionSort {

    public static Integer[] selectionSort(Integer[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * 中间循环不交换数组元素,只交换索引下标,只需要记录最小值的索引是什么 最后比较出来最小值用  i 和 min下标的元素交换一次就行
     * @param array
     * @return
     */
    public static Integer[] selectionSort1(Integer[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                // 核心点 一直让当前最小的元素和下标为j的元素进行比较 找出最小元素下标
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            //如果最小元素就是i 则不需要自己和自己交换
            if (min != i) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
        return array;
    }
}
