package com.lu.sort;

import com.lu.Student;

/**
 * @author 小卢
 */
public class InsertionSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {

        printArray(-1);

        int size = array.length;
        //插入排序第一个元素不需要拍直接插入就行 i从1开始
        for (int i = 1; i < size; i++) {

            int right = i;
            int left = i -1;
            // 左边元素大于右边元素,交换一次位置
            while (cmp(array[left],array[right]) > 0) {
                swap(left, right);
                //如果左索引已经是0了那就不需要继续比较了
                if (left == 0) {
                    break;
                }
                //交换完一次索引左移
                left--;
                right--;
            }
            printArray(i);
        }
    }
}
