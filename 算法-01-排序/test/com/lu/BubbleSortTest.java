package com.lu;


import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void bubbleSort() {
        Integer[] nums = new Integer[]{4, 2, 6, 7, 54, 21, 354, 321, 4, 2, 0, 4, 3, 9, 12, 56, 33};
        System.out.println(nums.length);
        Integer[] integers = new BubbleSort().bubbleSort(nums);
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+"->");
        }
        System.out.println();
        System.out.println(nums.length);
    }
}