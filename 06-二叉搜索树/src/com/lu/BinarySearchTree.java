package com.lu;

import com.lu.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author 小卢
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {


    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        Node node1 = (Node) node;
        return node1.left;
    }

    @Override
    public Object right(Object node) {
        Node node1 = (Node) node;
        return node1.right;
    }

    @Override
    public Object string(Object node) {
        Node node1 = (Node) node;
        return node1.element;
    }

    private static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public int height() {
        return heightLevel(root);
    }

    /**
     * 每当一层遍历完 队列的size就是下一层元素的个数
     * @param node
     * @return
     */
    private int heightLevel(Node<E> node) {

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        // 记录每一层有几个节点
        int levelSize = 1;
        int height = 0;
        while (!queue.isEmpty()) {
            // 进来先弹出节点然后offer左右节点
            node = queue.poll();
            // 每处理完一个节点就把当前层待处理节点数减一
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            // 当本层要处理的数量为0,证明成功处理完一层 高度+1 levelSize设置为queue.size(下一层所有元素的数量)
            if (levelSize == 0) {
                height++;
                levelSize = queue.size();
            }
        }
        return height;
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void add(E element) {
        elementNotNullCheck(element);
        //添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
        }
        //添加不是第一个节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compareTo(node.element, element);
            parent = node;
            if (cmp > 0) {
                node = node.left;
            } else if (cmp < 0) {
                node = node.right;
            } else {
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.left = newNode;
        } else if (cmp < 0) {
            parent.right = newNode;
        }
        size++;
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void preOrderTraversal(Visitor visitor) {
        preOrderTraversal(root, visitor);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void inOrderTraversal(Visitor visitor) {
        inOrderTraversal(root, visitor);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public void postOrderTraversal(Visitor visitor) {
        postOrderTraversal(root, visitor);
    }

    /**
     * 用户自定义遍历规则
     * 要求每次开始使用之前必须要把stop重置为false
     * @param <E>
     */
    public static class Visitor<E> {
        boolean stop;

        private final Predicate<E> predicate;

        public Visitor(Predicate<E> predicate) {
            this.predicate =  predicate;
        }

        /**
         * 使用者可以自定义遍历输出规则
         * @param element
         */
        public boolean visitor(E element) {
            return this.predicate.test(element);
        }

    }

    public void levelOrderTraversal(Visitor<E> visitor) {
        //利用队列特性,先进先出
        levelOrderTraversal(root, visitor);
    }

    private void levelOrderTraversal(Node<E> node, Visitor<E> visitor) {
        //利用队列特性,先进先出
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            node = queue.poll();
            visitor.visitor(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void levelOrderTraversal() {
        //利用队列特性,先进先出
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(Node<E> node) {
        //利用队列特性,先进先出
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            node = queue.poll();
            System.out.println(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    private void postOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.element);
    }

    private void postOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        postOrderTraversal(node.left, visitor);
        postOrderTraversal(node.right, visitor);
        if (visitor.stop) {
            return;
        }
        visitor.stop = visitor.visitor(node.element);
    }

    private void inOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.element);
        inOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        inOrderTraversal(node.left, visitor);
        if (visitor.stop) {
            return;
        }
        visitor.stop = visitor.visitor(node.element);
        inOrderTraversal(node.right, visitor);
    }

    private void preOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void preOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null||visitor.stop) {
            return;
        }
        visitor.stop = visitor.visitor(node.element);
        preOrderTraversal(node.left, visitor);
        preOrderTraversal(node.right, visitor);
    }

    /**
     * 两个元素相比较e1大于e2返回一个正数 小于返回一个负数 等于返回0;
     *
     * @param e1
     * @param e2
     * @return
     */
    private int compareTo(E e1, E e2) {
        //如果有人通过有参构造传入了比较器,那么优先使用比较器
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        //如果直接通过无参构造创建的element,那么二叉树要求传入的对象必须实现comparable接口来做到可比较
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must be not null!");
        }
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

}
