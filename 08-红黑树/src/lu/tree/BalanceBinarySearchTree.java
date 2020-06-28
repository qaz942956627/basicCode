package lu.tree;

import java.util.Comparator;

/**
 * @author 小卢
 */
public class BalanceBinarySearchTree<E> extends BinarySearchTree<E> {

    public BalanceBinarySearchTree() {
        this(null);
    }

    public BalanceBinarySearchTree(Comparator<E> comparator) {
        super(comparator);
    }

    protected void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
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


    }

    protected void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);
    }


    /**
     *
     * @param r 失衡待调整子树的根节点
     * bdf不为空 其他可嫩为空 二叉树特性大小排序为a->f
     */
    protected void rotate(Node<E> r, Node<E> a, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f, Node<E> g) {

        // 让d成为子树的根节点
        d.parent = r.parent;
        if (r.isLeftChild()) {
            r.parent.left = d;
        } else if (r.isRightChild()) {
            r.parent.right = d;
        } else {
            // else 被旋转的节点是根节点
            root = d;
        }
        //先维护下层的线 a-b 永远相连 f-g永远相连
        //b-c
        b.right = c;
        if (c != null) {
            c.parent = b;
        }

        //ef
        f.left = e;
        if (e != null) {
            e.parent = f;
        }
        //再维护上层的线
        //bd
        d.left = b;
        b.parent = d;
        //df
        d.right = f;
        f.parent = d;


    }

}
