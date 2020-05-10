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
            }

        }
    }

    /**
     * 恢复平衡
     * @param node
     */
    private void reBalance(Node<E> node) {
    }

    private boolean isBalance(Node<E> node) {
        return isBalance(node);
    }

    /**
     * 更新节点的高度
     * @param node
     */
    private void updateHeight(Node<E> node) {
        updateHeight(node);
    }

    @Override
    protected Node<E> createNode(E element, Node<E> node) {
        return super.createNode(element, node);
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
    }
}
