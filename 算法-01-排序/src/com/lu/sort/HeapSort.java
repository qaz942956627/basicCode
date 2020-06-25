package com.lu.sort;

/**
 * @author 小卢
 */
public class HeapSort<E extends Comparable<E>> extends Sort<E>{

    private int heapSize;

    @Override
    protected void sort() {

        // 原地建堆
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1) {
            // 交换堆顶元素和尾部元素
            swap(0, --heapSize);

            //对0位置进行siftDown(恢复堆的性质)
            siftDown(0);
        }

    }


    /**
     * 让index位置的元素下滤
     * @param index
     */
    private void siftDown(int index) {
        E element = array[index];
        int half = heapSize >> 1;
        // 第一个叶子节点的索引 == 非叶子节点的数量
        // index < 第一个叶子节点的索引
        // 必须保证index位置是非叶子节点
        while (index < half) {
            // index的节点有2种情况
            // 1.只有左子节点
            // 2.同时有左右子节点

            // 默认为左子节点跟它进行比较
            int childIndex = (index << 1) + 1;
            E child = array[childIndex];

            // 右子节点
            int rightIndex = childIndex + 1;

            // 选出左右子节点最大的那个
            if (rightIndex < heapSize && cmpElements(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }

            if (cmpElements(element, child) >= 0) {
                break;
            }

            // 将子节点存放到index位置
            array[index] = child;
            // 重新设置index
            index = childIndex;
        }
        array[index] = element;
    }

}
