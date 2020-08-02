package com.lu;

/**
 * @author 小卢
 */
public class BinarySearch {

    /**
     * 被查找元素在数组中的位置,不存在返回-1
     * @param array
     * @param v
     * @return
     */
    public static int indexOf(int[] array, int v) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = array.length;
        int mid = 0;
        while (begin < end) {
            mid = (begin + end) >> 1;
            if (array[mid] < v) {
                begin = mid + 1;
            } else if (array[mid] > v) {
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 元素要插入的位置,第一个大于v的元素的位置
     * @param array
     * @param v
     * @return
     */
    public static int index(int[] array, int v) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = array.length;
        int mid = 0;
        while (begin < end) {
            mid = (begin + end) >> 1;
            if (v < array[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
