package com.lu;

import com.lu.printer.BinaryTreeInfo;

import java.util.Comparator;

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

    public void add(E element) {
        elementNotNullCheck(element);
        //添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
        } else {
            //添加不是第一个节点
            Node<E> parent = root;
            Node<E> node = root;
            int cmp = compareTo(node.element, element);
            while (node != null) {

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
        }
        size++;
    }

    /**
     * 两个元素相比较e1大于e2返回一个正数 小于返回一个负数 等于返回0;
     * @param e1
     * @param e2
     * @return
     */
    private int compareTo(E e1, E e2) {
        //如果有人通过有参构造传入了比较器,那么优先使用比较器
        if (comparator != null) {
            return comparator.compare(e1,e2);
        }
        //如果直接通过无参构造创建的element,那么二叉树要求传入的对象必须实现comparable接口来做到可比较
        return ((Comparable<E>)e1).compareTo(e2);
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
