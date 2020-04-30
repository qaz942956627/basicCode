package com.lu;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        //sub sub = new sub();
        //sub.doSomething();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        while (!list.isEmpty()){
            System.out.println(list.remove(0));
        }
    }
}



class main {
    private BigInteger[] last = new BigInteger[10];

    public synchronized void doSomething() {
        last[0] = BigInteger.valueOf(1);
        System.out.println(last[0].intValue());
        BigInteger[] clone = last.clone();
        System.out.println(clone[0].intValue());
        System.out.println(Thread.currentThread().getName()+"->  main");
    }
}

class sub extends main{
    @Override
    public synchronized void doSomething() {
        System.out.println(Thread.currentThread().getName()+"->  sub");
        super.doSomething();
    }
}
