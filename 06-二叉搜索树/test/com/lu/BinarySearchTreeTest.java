package com.lu;

import com.lu.printer.BinaryTrees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTree;

    @BeforeEach
    void init() {
        //binarySearchTree = new BinarySearchTree<>(Person::compareTo);
        binarySearchTree = new BinarySearchTree<>();
        //Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3, 1, 12, 13};
        Integer[] data = {329, 238, 245, 80, 390, 409, 244, 374, 95, 412, 44, 310, 262, 293, 126, 137, 214, 228, 38, 436, 358, 463, 489, 417, 166, 111, 461, 61, 452, 30, 394, 464, 132, 426, 269, 265, 314, 472, 309, 26, 480, 367, 284, 232, 316, 300, 383};
        for (int i = 0; i < data.length; i++) {
            binarySearchTree.add(data[i]);
        }
    }

    @Test
    void remove() {
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.remove(436);
        BinaryTrees.println(binarySearchTree);
    }

    @Test
    void contains() {
    }
    @Test
    void complete() {
        BinaryTrees.println(binarySearchTree);
        System.out.println(binarySearchTree.isComplete());
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
    void height() {
        BinaryTrees.println(binarySearchTree);
        System.out.println(binarySearchTree.height());
    }

    @Test
    void print() {
        BinaryTrees.println(binarySearchTree);
        Predicate<Integer> predicate = (element) -> {
            System.out.print("_" + element);
            return element == 3;
        };
        BinarySearchTree.Visitor<Integer> visitor = new BinarySearchTree.Visitor<>(predicate);
        binarySearchTree.preOrderTraversal(visitor);
        System.out.println("前序遍历完成");
        //visitor = new BinarySearchTree.Visitor<>(predicate);
        visitor.stop = false;
        binarySearchTree.inOrderTraversal(visitor);
        System.out.println("中序遍历完成");
        //visitor = new BinarySearchTree.Visitor<>(predicate);
        visitor.stop = false;
        binarySearchTree.postOrderTraversal(visitor);
        System.out.println("后续遍历完成");
        //binarySearchTree.levelOrderTraversal();
        //binarySearchTree.levelOrderTraversal(visitor);
    }

    @Test
    void preOrderTraversal() {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.peek());
    }

}