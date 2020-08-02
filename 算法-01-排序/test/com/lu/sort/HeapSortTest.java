package com.lu.sort;

import com.lu.tools.Asserts;
import com.lu.tools.Integers;
import com.lu.tools.Times;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HeapSortTest {

    private Integer[] array;

    @BeforeEach
    void before() {
        array = Integers.random(10000, 1, 10000);
    }

    @Test
    void sort() {
        testSorts(array,
				new BubbleSort1(),		// 冒泡排序
				new BubbleSort2(),		// 冒泡排序-优化1
				new BubbleSort(),		// 冒泡排序-优化2
				new SelectionSort(), 	// 选择排序
                new HeapSort(),  		// 堆排序
				new InsertionSort1(),   // 插入排序
				new InsertionSort(), 	// 插入排序-挪动优化
                new InsertionSort3(),	// 插入排序-二分查找优化
                new MergeSort() 		// 归并排序
//                new QuickSort(),     	// 快速排序
//                new ShellSort()		// 希尔排序
//				new CountingSort(),		// 计数排序
//				new RadixSort()			// 基数排序
        );


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