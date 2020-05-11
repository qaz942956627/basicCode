package com.lu.sort;

import com.lu.tools.Integers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    private Sort<Integer> sort;
    Integer[] array;

    @BeforeEach
    void before() {
        array = array = Integers.random(20, 1, 1000);

        //Integers.println(array);
        Integer[] array1 = Integers.copy(array);
        Integer[] array2 = Integers.copy(array);

        sort = new InsertionSort<>();
    }

    @Test
    void sort() {
        sort.sort(array);
        sort.printArray(-2);
    }

    @AfterEach
    void after() {
        System.out.println(sort);
    }
}