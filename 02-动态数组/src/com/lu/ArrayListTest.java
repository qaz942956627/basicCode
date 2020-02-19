package com.lu;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author 小卢
 */
public class ArrayListTest {

    private ArrayList<Integer> list;

    @BeforeAll
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(1);

    }

    @Test
    public void size() {
        assertEquals(1, list.size());
    }

    @Test
    public void isEmpty() {
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void contains() {
        assertEquals(true, list.contains(1));

    }

    @Test
    public void add() {
        list.add(2);
        Integer integer = list.get(1);
        assertEquals(new Integer(2), integer);
    }

    @Test
    public void get() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(2));

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