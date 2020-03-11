package com.lu;

/**
 * @author 小卢
 */
public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        Node<E> node = new Node<>(element, null);
        if (index == 0) {
            node.next = this.first;
            this.first = node;
        } else {
            Node<E> preNode = node(index - 1);
            node.next = preNode.next;
            preNode.next = node;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        Node<E> node = node(index);
        if (index == 0) {
            this.first = this.first.next;
        } else {
            Node<E> preNode = node(index - 1);
            preNode.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = this.first;
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (node.element == element) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.first = null;
    }

    /**
     * 获取index对应的节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        checkRange(index);

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            return node.next;
        }
        return node;
    }

}
