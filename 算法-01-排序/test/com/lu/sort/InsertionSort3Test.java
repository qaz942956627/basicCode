package com.lu.sort;

import com.lu.tools.Asserts;
import com.lu.tools.Integers;
import com.lu.tools.Times;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSort3Test {

    @Test
    void sort() {
        Integer[] array = Integers.random(10000, 1, 20000);

        testSorts(array,
                new InsertionSort3()
        );
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}