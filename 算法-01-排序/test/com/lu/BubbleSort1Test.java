package com.lu;


import com.lu.sort.BubbleSort1;
import com.lu.sort.SelectionSort1;
import com.lu.tools.Integers;
import com.lu.tools.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

class BubbleSort1Test {

    Integer[] nums;

    @BeforeEach
    void before() {
        nums = new Integer[]{4, 6, 7, 54, 21, 354, 321,  2, 33,500};
    }

    @Test
    void selectionSortTest() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"->");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        Integer[] integers = SelectionSort1.selectionSort1(nums);
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+"->");
        }
        System.out.println();
        //System.out.println(nums.length);
    }

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
        Integer[] integers = new BubbleSort1().bubbleSort3(nums);
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+"->");
        }
        System.out.println();
        //System.out.println(nums.length);
    }

    @Test
    void bubbleSort2() {
        //Integer[] array = Integers.tailAscOrder(1, 10000, 2000);
        Integer[] array = Integers.ascOrder(1, 10000);

        //Integers.println(array);
        Integer[] array1 = Integers.copy(array);
        Integer[] array2 = Integers.copy(array);

        Times.test("bubbleSort",()-> BubbleSort1.bubbleSort(array));
        Times.test("bubbleSort1",()-> BubbleSort1.bubbleSort2(array1));
        Times.test("bubbleSort2",()-> BubbleSort1.bubbleSort3(array2));

    }

    @Test
    void test() {
        LocalTime start = LocalTime.now();
        Random random = new Random();
        for (int i = 0; i < 100000000; i++) {
            int i1 = random.nextInt() / 2;
        }
        LocalTime end = LocalTime.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

    @Test
    void test2() {
        LocalTime start = LocalTime.now();
        Random random = new Random();
        for (int i = 0; i < 100000000; i++) {
            int i1 = random.nextInt() >> 1;
        }
        LocalTime end = LocalTime.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

}