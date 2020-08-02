package com.lu.sort;

/**
 * @author 小卢
 */
public class MergeSort<E extends Comparable<E>> extends Sort<E> {

    private E[] leftArray;


    @Override
    protected void sort() {
        leftArray = (E[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 二分数组
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
     * @param begin
     * @param mid
     * @param end
     */
    private void merge(int begin, int mid, int end) {
        //备份的左边数组
        int leftStart = 0, leftEnd = mid - begin;
        //实际的数组右边区域
        int rightStart = mid, rightEnd = end;
        //覆盖实际数组的索引
        int currIndex = begin;
        //备份数组
        for (int i = leftStart; i < leftEnd; i++) {
            leftArray[i] = array[begin + i];
        }
        //只要左边还有没处理完了的就继续处理 如果左边的先处理完了 因为都是顺序数组右边剩下的就直接是顺序的不需要处理了
        while (leftStart < leftEnd) {
            // 右边的数组不能越界 , 只有在右边的数组元素小于左边的覆盖过去 ,这样可以保证排序的稳定性
            if (rightStart < rightEnd  && cmpElements(array[rightStart], array[leftStart]) < 0) {
                array[currIndex++] = array[rightStart++];
            } else {
                array[currIndex++] = leftArray[leftStart++];
            }
        }
    }
}
