package com.lu.chapter5;

public class Test1 {
     String bowl1 = "super";

     public Test233 test233 = new Test233();

     static {
         System.out.println("静态代码块");
     }

     public static void staticMethod(){
         System.out.println("staticMethod");
     }


    public Test1() {
        System.out.println("构造()");
    }

    public void test23123123() {
        String i = test233.getI();
        System.out.println(i);
    }
}

