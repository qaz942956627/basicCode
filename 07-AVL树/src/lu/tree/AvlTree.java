package lu.tree;


import java.util.Comparator;

/**
 * @author 小卢
 */
public class AvlTree<E> extends BinarySearchTree<E> {

    public AvlTree() {
        this(null);
    }

    public AvlTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void addAfter(Node<E> node) {
        //添加一个元素之后往上找第一个失衡的节点 只要把第一个失衡的节点调整平衡 更上面的父节点自然平衡了
        //新插入的节点一定是叶子节点,在AVL树中叶子节点的父节点度一定为 1 一定是平衡的 所以可以直接parent一次
        while ((node = node.parent) != null) {
            // 判断当前节点是否平衡
            if (isBalance(node)) {
                //如果是平衡的 在遍历每个父节点的时候顺便更新他的高度
                updateHeight(node);
            } else {
                //如果是不平衡的 那么根据情况旋转 恢复平衡
                reBalance(node);
                //进入else则找到第一个不平衡的节点,把这个节点恢复平衡整棵树恢复平衡
                break;
            }

        }
    }

    /**
     * 恢复平衡
     * @param grand 高度最低的那个失衡的节点
     */
    private void reBalance(Node<E> grand) {
        Node<E> parent = ((AvlNode<E>) grand).tallerChild();
        Node<E> node = ((AvlNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {
            // L
            if (node.isLeftChild()) {
                // LL
                rotateRight(grand);
            } else {
                // LR
                // 先把parent进行一次左旋转,变成LL的情况
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else {
            // R
            if (node.isLeftChild()) {
                // RL
                // 先把parent进行一次右旋转,变成RR的情况
                rotateRight(parent);
                rotateLeft(grand);
            } else {
                // RR
                rotateLeft(grand);
            }
        }
    }

    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        // 让parent成为子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            // else 被旋转的节点是根节点
            root = parent;
        }
        //更新child的parent
        if (child != null) {
            child.parent = grand;
        }
        //更新grand的parent
        grand.parent = parent;

        //更新高度
        updateHeight(grand);
        updateHeight(parent);
    }

    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);
    }

    private boolean isBalance(Node<E> node) {
        AvlNode<E> avlNode = (AvlNode<E>) node;
        return avlNode.isBalance();
    }

    /**
     * 更新节点的高度
     * @param node
     */
    private void updateHeight(Node<E> node) {
        AvlNode<E> avlNode = (AvlNode<E>) node;
        avlNode.height = avlNode.updateHeight();
    }

    @Override
    protected Node<E> createNode(E element, Node<E> node) {
        return new AvlNode<>(element, node);
    }

    private static class AvlNode<E> extends Node<E> {

        //新插入节点一定是叶子节点,高度必然是1
        int height = 1;

        public AvlNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftBalance = left == null ? 0 : ((AvlNode<E>) left).height;
            int rightBalance = right == null ? 0 : ((AvlNode<E>) right).height;
            return leftBalance - rightBalance;
        }

        public boolean isBalance() {
            return Math.abs(balanceFactor()) <= 1;
        }

        public int updateHeight() {
            int leftBalance = left == null ? 0 : ((AvlNode<E>) left).height;
            int rightBalance = right == null ? 0 : ((AvlNode<E>) right).height;
            return Math.max(leftBalance,rightBalance) + 1;
        }

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>) right).height;
            //返回左右子树高度更高的子树
            if (leftHeight > rightHeight) {
                return left;
            }
            if (leftHeight < rightHeight) {
                return right;
            }
            //如果左右字数高度相同 自己是父节点的左子节点就返回左,是右边就返回右
            return isLeftChild() ? left : right;
        }

        @Override
        public String toString() {
            String parentString = "null";
            if (parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_P(" + parentString + ")_h(" + height +")";
        }

    }


}
