package com.lu;

/**
 * @author 小卢
 * @version 1.0
 * @date 2023/1/2 21:49
 **/
public class Hanoi {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3, "A", "B", "C");
    }

    public void hanoi(int n, String A, String B, String C) {
        if (n == 1) {
            move(n, A, C);
            return;
        }
        hanoi(n - 1, A, C, B);
        move(n, A, C);
        hanoi(n - 1, B, A, C);
    }

    private void move(int n, String A, String C) {
        System.out.printf("将%s号盘子从%s挪动到%s%n", n, A, C);
    }
}
