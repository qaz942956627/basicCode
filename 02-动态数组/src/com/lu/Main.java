package com.lu;

/**
 * @author 小卢
 */
public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(18);
        list.add(19);
        list.add(10);
        System.out.println(list.contains(10));
        System.out.println(list.contains(100));
        System.out.println(list.get(3));
        try {
            System.out.println(list.get(20));
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        try {
            System.out.println(list.get(-1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.indexOf(16));
        System.out.println(list.indexOf(20));
        try {
            System.out.println(list.indexOf(-2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.isEmpty());
        System.out.println(list.remove(3));
        try {
            System.out.println(list.remove(-1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(list.remove(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.clear();
        System.out.println(list.isEmpty());
    }
}
