package lu.tree;

import java.util.Comparator;

/**
 * @author 小卢
 */
public class RedBlackTree<E> extends BinarySearchTree<E> {

    public static final boolean RED = false;
    public static final boolean BLACK = true;

    public RedBlackTree() {
        this(null);
    }

    public RedBlackTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void removeAfter(Node<E> node) {
        super.removeAfter(node);
    }

    @Override
    protected void addAfter(Node<E> node) {
        super.addAfter(node);
    }

    private Node<E> color(Node<E> node, boolean color) {
        if (node != null) {
            ((RedBlackNode<E>) node).color = color;
        }
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RedBlackNode<E>) node).color;
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    public static class RedBlackNode<E> extends Node<E> {

        boolean color;

        public RedBlackNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }


}
