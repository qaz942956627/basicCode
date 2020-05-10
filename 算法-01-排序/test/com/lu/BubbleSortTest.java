package com.lu;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class BubbleSortTest {

    @Test
    void bubbleSort() {
        Integer[] nums = new Integer[]{4, 6, 7, 54, 21, 354, 321,  2, 33,500};
        //Integer[] nums = new Integer[]{7,5,4,8,20,13,22,23,24};
        //Arrays.sort(nums, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"->");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        Integer[] integers = new BubbleSort().bubbleSort3(nums);
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+"->");
        }
        System.out.println();
        //System.out.println(nums.length);
    }
}