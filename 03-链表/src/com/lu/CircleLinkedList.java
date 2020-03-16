package com.lu;

/**
 * @author 小卢
 */
public class CircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
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
        //往最后面添加元素的时候
        if (index == size) {
            Node<E> oldLast = this.last;
            last = new Node<>(oldLast, element, first);
            //这是空链表第一次添加元素的时候
            if (oldLast == null) {
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            //之前的prev改为新节点的prev
            prev.next = node;
            //只有node(0)的next才是first
            if (next == first) {
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = node;
        } else {
            prev.next = next;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
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
        this.last = null;
    }

    /**
     * 获取index对应的节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        checkRange(index);

        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                return node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                return node.prev;
            }
        }
        return node;
    }

}
