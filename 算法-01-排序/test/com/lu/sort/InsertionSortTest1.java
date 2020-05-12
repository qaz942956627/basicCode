package com.lu.sort;

import com.lu.tools.Integers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InsertionSortTest1 {

    private static Sort<Integer> sort;
    private static Sort<Integer> sort1;
    private static Integer[]  array;
    private static Integer[] array1;


    @BeforeAll
    static void before() {
        array = Integers.random(10, 1, 100);
        array1 = Integers.copy(array);

        sort = new InsertionSort<>();
        sort1 = new InsertionSort1<>();
    }

    @Test
    void sort() {
        sort.sort(array);
        sort.printArray(-2);
    }

    @Test
    void sort1() {

        sort1.sort(array1);
        sort1.printArray(-2);
    }

    @AfterEach
    void after() {
        System.out.println(sort);
        System.out.println();
    }
}