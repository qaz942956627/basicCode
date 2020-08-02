package com.lu.sort;

/**
 * 增加临时变量 让所有需要交换的元素全部右移  然后让最小的元素放到i的位置
 * @author 小卢
 */
public class InsertionSort1<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {

        //插入排序第一个元素不需要拍直接插入就行 i从1开始
        for (int i = 1; i < array.length; i++) {
            // 记录一下当前插入元素下标,where循环中会修改值
            int currIndex = i;
            // 备份当前插入元素 , 右移过程中会被覆盖
            E currElement = array[currIndex];
            // 如果当前元素的值小于前一个元素的值, 前一个元素右移
            while (cmpElements(currElement, array[currIndex - 1]) < 0) {
                // 右移操作
                array[currIndex] = array[currIndex - 1];
                currIndex--;
                if (currIndex == 0) {
                    break;
                }
            }
            /**
             * 每一次循环完了要么是比之前所有元素的值都小 currIndex=0了
             * 要么是where条件不满足退出了 当前元素的值已经是小于currIndex - 1了 那么它就应该在currIndex-1的位置
             * 因为循环每一次都会currIndex--所以
             */
            array[currIndex] = currElement;
        }
    }
}
