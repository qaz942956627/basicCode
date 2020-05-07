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
}
