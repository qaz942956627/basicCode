package lu.tree;

import lu.printer.BinaryTrees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RedBlackTreeTest {

    private RedBlackTree<Integer> rb;
    Integer[] data;

    @BeforeEach
    void init() {
        rb = new RedBlackTree<Integer>();
        data = new Integer[] {
                5, 9, 91, 62, 54, 69, 89, 51, 36
        };
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);

            /*System.out.println("---- "+data[i]+" ----");
            BinaryTrees.println(avl);
            System.out.println();*/
        }

    }



    @Test
    void addAfter() {
        BinaryTrees.println(rb);
    }

    @Test
    void remove() {

        for (int i = 0; i < data.length; i++) {
            rb.remove(data[i]);

            System.out.println("---- "+data[i]+" ----");
            BinaryTrees.println(rb);
            System.out.println();
        }
    }

}