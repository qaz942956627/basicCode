package com.lu;


import com.lu.sort.BubbleSort;
import com.lu.tools.Integers;
import com.lu.tools.Times;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

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
        Integer[] integers = SelectionSort.selectionSort1(nums);
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
        Integer[] integers = new BubbleSort().bubbleSort3(nums);
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

        Times.test("bubbleSort",()->BubbleSort.bubbleSort(array));
        Times.test("bubbleSort1",()->BubbleSort.bubbleSort2(array1));
        Times.test("bubbleSort2",()->BubbleSort.bubbleSort3(array2));

    }

}