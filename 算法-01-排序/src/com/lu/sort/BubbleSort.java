package com.lu.sort;

/**
 * @author 小卢
 */
public class BubbleSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        int size = array.length;
        int sortIndex = 0;
        //只要sortIndex不等于-1就说明要么是初始化等于0 要么是在做过交换被赋值了
        while (sortIndex != -1) {
            // 在数组初始完全有序的时候有用  完全有序 size = -1  i++ = 1 不满足 i < size 循环结束 复杂度 O(n)
            sortIndex = -1;
            for (int j = 1; j < size; j++) {
                /*if (nums[j] < nums[j - 1]) {
                    Integer tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                    //如果交换了记录一下最后一次交换j的位置
                    sortIndex = j;
                }*/

                if (cmp(j, j - 1) < 0) {
                    swap(j, j - 1);
                    //如果交换了记录一下最后一次交换j的位置
                    sortIndex = j;
                }
            }
            //下一次where循环遍历从0开始遍历的length
            size = sortIndex;
        }
    }
}
