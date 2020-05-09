package lu.tree;


import lu.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * @author 小卢
 */
public class BinaryTree<E> implements BinaryTreeInfo {


    protected int size;

    protected Node<E> root;

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

    protected static class Node<E> {
        protected E element;
        protected Node<E> parent;
        protected Node<E> left;
        protected Node<E> right;

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

    public void clear() {
        root = null;
    }


    /**
     * 获取一个节点的前驱节点
     * @param node
     * @return
     */
    protected Node<E> predecessor(Node<E> node) {
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
     * @param node
     * @return
     */
    protected Node<E> successor(Node<E> node) {
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
     * @param node
     * @return
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
     * @return
     */
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

    /**
     * 层序遍历
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }
    /**
     * 先序遍历
     */
    public void preOrderTraversal(Visitor visitor) {
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
     * @param visitor
     */
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

}
