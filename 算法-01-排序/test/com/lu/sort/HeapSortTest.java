package com.lu.sort;

import com.lu.tools.Asserts;
import com.lu.tools.Integers;
import com.lu.tools.Times;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HeapSortTest {

    private Sort<Integer> sort;
    private Sort<Integer> sort1;
    private Sort<Integer> sort2;
    Integer[] array;
    Integer[] array1;
    Integer[] array2;

    @BeforeEach
    void before() {
        array = array = Integers.random(10000, 1, 20000);
    }

    @Test
    void sort() {
        testSorts(array, new HeapSort<>(), new SelectionSort<>(), new BubbleSort<>());


    }

    static void testSorts(Integer[] array, Sort<Integer>... sorts) {
        for (Sort<Integer> sort : sorts) {
            sort.sort(Integers.copy(array));
        }
        Arrays.sort(sorts);
        for (Sort<Integer> sort : sorts) {
            System.out.println(sort);
        }
    }

}