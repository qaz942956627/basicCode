package com.lu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int[] ints = {1, 3, 4,4,4,4,4, 5, 7, 9};

    @Test
    void indexOf() {



        System.out.println(BinarySearch.indexOf(ints, 10));

    }

    @Test
    void index() {
        System.out.println(BinarySearch.index(ints,26));
    }
}