package lu.tree;

import java.util.Comparator;

/**
 * @author 小卢
 */
public class RedBlackTree<E> extends BalanceBinarySearchTree<E> {

    public static final boolean RED = false;
    public static final boolean BLACK = true;

    public RedBlackTree() {
        this(null);
    }

    public RedBlackTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void removeAfter(Node<E> node, Node<E> replacement) {
        // 如果删除的节点是红色
        if (isRed(node)) {
            return;
        }

        // 用以取代node的子节点是红色
        if (isRed(replacement)) {
            black(replacement);
            return;
        }

        Node<E> parent = node.parent;
        // 删除的是根节点
        if (parent == null) {
            return;
        }

        // 删除的是黑色叶子节点
        if (node.isLeftChild()) {
            //如果是左子节点

        } else if (node.isRightChild()) {

        }
    }

    @Override
    protected void addAfter(Node<E> node) {
        Node<E> parent = node.parent;

        //添加的节点是根节点
        if (parent == null) {
            black(node);
        }

        //如果父节点是黑色
        if (isBlack(parent)) {
            return;
        }

        //uncle节点
        Node<E> uncle = parent.sibling();
        //祖父节点
        Node<E> grand = red(parent.parent);
        if (isRed(uncle)) {
            //叔父节点是红色[B树节点上溢的情况]
            black(parent);
            black(uncle);
            //把祖父节点当成新添加的节点
            addAfter(grand);
            return;
        }

        // 叔父节点不是红色
        if (parent.isLeftChild()) {
            // L
            if (node.isLeftChild()) {
                // LL
                black(parent);
            } else {
                // LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else {
            // R
            if (node.isLeftChild()) {
                // RL
                black(node);
                rotateRight(parent);
            } else {
                // RR
                black(parent);
            }
            rotateLeft(grand);
        }
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

    @Override
    protected Node<E> createNode(E element, Node<E> node) {
        return new RedBlackNode<>(element, node);
    }

    public static class RedBlackNode<E> extends Node<E> {

        boolean color = RED;

        public RedBlackNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }


}
