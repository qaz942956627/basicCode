package com.lu.heap;

import com.lu.heap.printer.BinaryTreeInfo;
import com.lu.heap.printer.BinaryTrees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    @Test
    void add() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(2);
        heap.add(4);
        heap.add(8);
        heap.add(6);
        heap.add(9);
        heap.add(7);
        heap.add(23);
        heap.add(11);
        BinaryTrees.print(heap);
    }
}