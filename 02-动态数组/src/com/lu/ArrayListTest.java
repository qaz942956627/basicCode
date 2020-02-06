package com.lu;


import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 小卢
 */
public class ArrayListTest {

    private ArrayList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(1);

    }

    @Test
    public void size() {
        Assert.assertEquals(1,list.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(false,list.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertEquals(true,list.contains(1));

    }

    @Test
    public void add() {
        list.add(2);
        Integer integer = list.get(1);
        Assert.assertEquals(new Integer(2),integer);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        //Assert.assertEquals(new Integer(1),list.get(0));
        //list.get(-1);
        list.get(2);
    }

    @Test
    public void set() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void clear() {
    }
}