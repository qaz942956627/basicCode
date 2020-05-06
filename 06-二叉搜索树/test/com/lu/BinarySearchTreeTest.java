package com.lu;

import com.lu.printer.BinaryTrees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTree;

    @BeforeEach
    void init() {
        //binarySearchTree = new BinarySearchTree<>(Person::compareTo);
        binarySearchTree = new BinarySearchTree<>();
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void add() {
        Person person1 = new Person(18,"lisa");
        Person person2 = new Person(20,"ami");
        Person person3 = new Person(16,"dear");
//        binarySearchTree.add(person1);
//        binarySearchTree.add(person2);
//        binarySearchTree.add(person3);
        System.out.println(person1);
    }

    @Test
    void print() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3, 1, 12};
        for (int i = 0; i < data.length; i++) {
            binarySearchTree.add(data[i]);
        }
        BinaryTrees.println(binarySearchTree);
        BinarySearchTree.Visitor visitor = (element) -> {
            System.out.print("_" + element);
        };
        binarySearchTree.preOrderTraversal(visitor);
        System.out.println();
        binarySearchTree.inOrderTraversal(visitor);
        System.out.println();
        binarySearchTree.postOrderTraversal(visitor);
        System.out.println();
        //binarySearchTree.levelOrderTraversal();
        binarySearchTree.levelOrderTraversal(visitor);
    }

    @Test
    void preOrderTraversal() {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.peek());
    }

    @Test
    void remove() {
    }

    @Test
    void contains() {
    }
}