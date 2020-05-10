package com.lu;

/**
 * 冒泡排序
 *
 * @author 小卢
 */
public class BubbleSort {

    public Integer[] bubbleSort(Integer[] nums) {
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

    public Integer[] bubbleSort2(Integer[] nums) {
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

    public Integer[] bubbleSort3(Integer[] nums) {
        int size = nums.length;
        //实际上这个for循环就是一个 sortIndex != -1 的where循环
        for (int i = 1; i < size; i++) {

            // 在数组初始完全有序的时候有用  完全有序 size = -1  i++ = 1 不满足 i < size 循环结束 复杂度 O(n)
            int sortIndex = -1;
            for (int j = 0; j < size - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    Integer tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    //如果交换了记录一下最后一次交换j的位置
                    sortIndex = j;
                }
            }
            size = sortIndex +1;
            i=0;
        }
        return nums;
    }
}
