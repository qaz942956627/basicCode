package com.lu.sort;

/**
 * 冒泡排序
 *
 * @author 小卢
 */
public class BubbleSort1 {

    public static Integer[] bubbleSort(Integer[] nums) {
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    Integer tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }

    public static Integer[] bubbleSort2(Integer[] nums) {
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            boolean flg = true;
            for (int j = 0; j < size - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    Integer tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flg = false;
                }
            }
            if (flg) {
                return nums;
            }
        }
        return nums;
    }

    public static Integer[] bubbleSort3(Integer[] nums) {
        int size = nums.length;
        int sortIndex = 0;
        //只要sortIndex不等于-1就说明要么是初始化等于0 要么是在做过交换被赋值了
        while (sortIndex != -1) {
            // 在数组初始完全有序的时候有用  完全有序 size = -1  i++ = 1 不满足 i < size 循环结束 复杂度 O(n)
            sortIndex = -1;
            for (int j = 1; j < size; j++) {
                if (nums[j] < nums[j - 1]) {
                    Integer tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                    //如果交换了记录一下最后一次交换j的位置
                    sortIndex = j;
                }
            }
            //下一次where循环遍历从0开始遍历的length
            size = sortIndex;
        }
        //只要这次where循环没有交换过数据 就返回数组
        return nums;
    }
}
