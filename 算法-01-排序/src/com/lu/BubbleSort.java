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
        int end  = size -1;
        /*for (int i = 0; i < end; ) {

            for (int f = 0; f < nums.length; f++) {
                System.out.print(nums[f]+"->");
            }
            System.out.print( "    end"+end+"->");
            System.out.println();
        }*/

        int sortIndex;
        do {
            // 在数组初始完全有序的时候有用  完全有序 size = 2  i++ = 2 不满足 i < size 循环结束 复杂度 O(n)
            sortIndex = -1;
            for (int j = 0; j < end; j++) {
                if (nums[j] > nums[j + 1]) {
                    Integer tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    //如果交换了记录一下最后一次交换j的位置
                    sortIndex = j;
                }
            }
            end = sortIndex + 1;
            for (int f = 0; f < nums.length; f++) {
                System.out.print(nums[f]+"->");
            }
            System.out.print( "    end"+end+"->");
            System.out.println();
        } while (sortIndex != -1);
        return nums;
    }
}
