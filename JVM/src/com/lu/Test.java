package com.lu;

/**
 * @author 小卢
 */
public class Test {

    private static int num = 1;

    static {
        num =2 ;
        System.out.println("static"+num);
        number = 20;
        //System.out.println(number);

    }

    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(Test.num);
        System.out.println(Test.number);
    }
}
