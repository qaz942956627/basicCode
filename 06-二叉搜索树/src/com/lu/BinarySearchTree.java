package com.lu;

import com.lu.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * @author 小卢
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {


    private int size;

    private Node<E> root;

    private final Comparator<E> comparator;

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

    public static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        size--;
        //度为2的节点
        if (node.hasTwoChildren()) {
            //找到这个节点的前驱节点或者后继节点
            Node<E> predecessor = predecessor(node);
            //用前驱节点的值替换当前节点的值
            node.element = predecessor.element;
            //度为2的节点的前驱结点度一定为0或者1
            // 所以可以在这直接把当前节点设置为前驱节点
            // 后边的代码是处理删除度为0和1的
            node = predecessor;
        }

        // 删除node节点（node的度必然是1或者0）
        Node<E> parent = node.parent;
        Node<E> children = node.left != null ? node.left : node.right;

        /*
         * parent   爷爷
         * node     儿子
         * child    孙子
         */
        // node是度为1的节点
        if (children != null) {
            // 孙子认爷当爹
            children.parent = parent;
            // 更改parent的left、right的指向
            if (parent == null) {
                // node是度为1的节点并且是根节点
                root = children;
            } else if (node == parent.left) {
                parent.left = children;
            } else { // node == node.parent.right
                parent.right = children;
            }
        } else if (parent == null) {
            //如果父节点和子节点都为null那么证明这棵树只有root节点
            root = null;
        } else {
            //如果被删除节点是parent的左子节点
            if (parent.left == node) {
                parent.left = null;
            } else {
                //如果不是左节点那么一定是右节点
                parent.right = null;
            }
        }
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    public void clear() {
        root = null;
    }

    private Node<E> node(E element) {
        //不允许为null直接返回null
        if (element == null) {
            return null;
        }
        //首先和root进行比较
        Node<E> node = this.root;
        while (node != null) {
            int cmp = compareTo(element, node.element);
            //如果传入元素和当前node的元素相等那么返回这个node
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                //如果element比当前元素大那么往右找更大的值
                node = node.right;
            } else {
                //剩下的就是element笔当前元素小的 ,那么需要往左找元素值更小的node
                node = node.left;
            }
        }
        //所有都找完了没有相等的 那么返回null 没找到
        return null;
    }

    /**
     * 获取一个节点的前驱节点
     *
     * @param node 节点
     * @return {@link Node}<{@link E}>
     */
    private Node<E> predecessor(Node<E> node) {
        //如果传进来的是null,则必然没有什么前驱节点
        if (node == null) {
            return null;
        }
        //如果左子节点不为空那么前驱节点一定在左子节点中
        if (node.left != null) {
            //前驱节点一定在左子树中
            node = node.left;
            //终止条件右子节点为空那么此时node就是前驱节点
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
        //如果满足左子节点为空但是父节点不为空,那么前驱节点一定是在一直向右找的过程中第一次向左的那个父节点
        Node<E> parent = node.parent;
        while (parent != null && parent.left == node) {
            //一直向右找到父节点
            node = parent;
        }
        //第一次向左寻找父节点,这个父节点就是前驱节点,剩下的就是没有左子节点,也没有父节点,只有右子节点的那么它本身就是最小的一个没有前驱节点
        return parent;
    }

    /**
     * 获取一个节点的后继节点
     *
     * @param node 节点
     * @return {@link Node}<{@link E}>
     */
    private Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        Node<E> parent = node.parent;
        while (parent != null && parent.right == node) {
            node = parent;
        }
        return parent;
    }

    public boolean isComplete() {
        return isComplete(root);
    }

    /**
     * 判断一棵树是否是完全二叉树
     *
     * @param node 节点
     * @return boolean
     */
    private boolean isComplete(Node<E> node) {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        // 记录是否出现叶子节点或者只有左子节点的节点
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            node = queue.poll();
            // 如果出现一个节点的右子节点不为null并且佐子结点为null的情况就说明这个树不是完全二叉树

            if (isLeaf && !node.isLeaf()) {
                return false;
            }

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                isLeaf = true;
            }
        }
        return true;
    }

    /**
     * 获取树的高度
     *
     * @return int
     */
    public int height() {
        return heightLevel(root);
    }

    /**
     * 每当一层遍历完 队列的size就是下一层元素的个数
     *
     * @param node 节点
     * @return int
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
        } else {
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
            } else {
                parent.right = newNode;
            }
        }
        size++;
    }

    /**
     * 先序遍历
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    /**
     * 先序遍历
     */
    public void preOrderTraversal(Visitor<E> visitor) {
        preOrderTraversal(root, visitor);
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    /**
     * 中序遍历
     *
     * @param visitor visitor
     */
    public void inOrderTraversal(Visitor<E> visitor) {
        inOrderTraversal(root, visitor);
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public void postOrderTraversal(Visitor<E> visitor) {
        postOrderTraversal(root, visitor);
    }

    /**
     * 用户自定义遍历规则
     * 要求每次开始使用之前必须要把stop重置为false
     *
     * @param <E>
     */
    public static class Visitor<E> {
        boolean stop;

        private final Predicate<E> predicate;

        public Visitor(Predicate<E> predicate) {
            this.predicate = predicate;
        }

        /**
         * 使用者可以自定义遍历输出规则
         *
         * @param element 元素
         * @return boolean
         */
        public boolean visitor(E element) {
            return this.predicate.test(element);
        }

    }

    public void levelOrderTraversal(Visitor<E> visitor) {
        //利用队列特性,先进先出
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            Node<E> node = queue.poll();
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
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            Node<E> node = queue.poll();
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
        if (node == null || visitor.stop) {
            return;
        }
        visitor.stop = visitor.visitor(node.element);
        preOrderTraversal(node.left, visitor);
        preOrderTraversal(node.right, visitor);
    }

    /**
     * 两个元素相比较e1大于e2返回一个正数 小于返回一个负数 等于返回0;
     *
     * @param e1 e1
     * @param e2 e2
     * @return int
     */
    @SuppressWarnings("unchecked")
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

}
