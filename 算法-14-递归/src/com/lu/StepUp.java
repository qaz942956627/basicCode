package com.lu;

/**
 * @author 小卢
 * @version 1.0
 * @date 2023/1/2 18:07
 **/
public class StepUp {

    public static void main(String[] args) {
        StepUp stepUp = new StepUp();
        int n = 1;
        System.out.println(stepUp.stepUp(n));
        System.out.println(stepUp.stepUp2(n));
    }


    public int stepUp(int n) {
        if (n < 3) {
            return n;
        }
        return stepUp(n - 1) + stepUp(n - 2);
    }

    public int stepUp2(int n) {
        if (n < 3) {
            return n;
        }
        int first = 1;
        int secend = 2;
        for (int i = 2; i < n; i++) {
            int tmp = first;
            first = secend;
            secend = tmp + secend;
        }
        return secend;
    }
}
