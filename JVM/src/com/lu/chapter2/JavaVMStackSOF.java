package com.lu.chapter2;

/**
 * VM Args: -Xss128k
 * @author 小卢
 * @version 1.0
 * @date 2022/7/30 23:43
 **/
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈长度:" + oom.stackLength);
            throw e;
        }
    }
}
