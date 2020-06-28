package lu.tree;

import lu.printer.BinaryTrees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class AvlTreeTest {

    private AvlTree<Integer> avl;
    Integer[] data;

    @BeforeEach
    void init() {
        avl = new AvlTree<>();
        data = new Integer[] {93, 51, 46, 40, 54, 41, 99, 71, 74, 28, 89, 7, 69, 3, 26, 39, 59, 82, 81, 4, 23};
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);

            /*System.out.println("---- "+data[i]+" ----");
            BinaryTrees.println(avl);
            System.out.println();*/
        }

    }



    @Test
    void addAfter() {
        BinaryTrees.println(avl);
    }

    @Test
    void remove() {

        for (int i = 0; i < data.length; i++) {
            avl.remove(data[i]);

            System.out.println("---- "+data[i]+" ----");
            BinaryTrees.println(avl);
            System.out.println();
        }
    }

}