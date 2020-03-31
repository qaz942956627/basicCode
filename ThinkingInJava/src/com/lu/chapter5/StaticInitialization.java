package com.lu.chapter5;

/**
 * 类初始化
 * 静态成员和静态代码块->普通成员和非静态代码块->构造函数
 * 子类初始化过程
 * 父类静态成员和静态代码块->子类静态成员和静态代码块
 * ->父类普通成员和非静态代码块->父类构造函数
 * ->子类普通成员和非静态代码块->子类构造函数
 *
 */
class Bowl {
    public Bowl(int marker) {
        System.out.println("bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);
    public Table() {
        System.out.println("table()");
        bowl2.f1(1);

    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }
    static Bowl bowl2 = new Bowl(2);

    {
        System.out.println("非静态代码块");
    }

    static {
        System.out.println("静态代码块");
    }
}

class Cupboard {
    private static  int i;

    static {
        i = 15;
    }
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    public Cupboard() {
        i = 39;
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}

class Test {
    protected Bowl bowl1;

     {
         bowl1 = new Bowl(1);
         System.out.println("非静态代码块");
    }
    public Test() {
        System.out.println("构造()");
    }
}

public class StaticInitialization {
    /*public static void main(String[] args) {
        System.out.println("creating new cup in main");
        new Cupboard();


        System.out.println("creating new cup in main");
        new Cupboard();

        table.f2(1);
        cupboard.f3(1);


    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();*/

    //非静态代码块每次初始化都会调用
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.bowl1);
        Test test2 = new Test();
        System.out.println(test2.bowl1);
    }



}
