package com.lu;

/**
 * @author 小卢
 */
public class Main {

    // 0 1 1 2
    public static void main(String[] args) {
        System.out.println(fbnq(3));
        System.out.println(fbnq2(3));
    }

    /***
     * 求0 1开头的第n个斐波那契数列的值
     * @param n
     */
    public static int fbnq(int n) {
        if (n < 2) {
            return n;
        }
        return fbnq(n - 2) + fbnq(n - 1);
    }

    /***
     * 求0 1开头的第n个斐波那契数列的值
     * @param n
     */
    public static int fbnq2(int n) {
        if (n<2){
            return n;
        }
        int first = 0;
        int second = 1;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = first+second;
            first = second;
            second = sum;
        }
        return second;
    }
}
