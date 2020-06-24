package lu.tree;


import java.util.Comparator;

/**
 * @author 小卢
 */
public class BinarySearchTree<E> extends BinaryTree<E> {

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
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
            //删除前驱节点
            node = predecessor;
        }

        // 删除node节点（node的度必然是1或者0）
        Node<E> parent = node.parent;
        Node<E> children = node.left != null ? node.left : node.right;

        /**
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

    public void add(E element) {
        elementNotNullCheck(element);
        //添加第一个节点
        if (root == null) {
            root = createNode(element,null);
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
            Node<E> newNode = createNode(element, parent);
            if (cmp > 0) {
                parent.left = newNode;
            } else if (cmp < 0) {
                parent.right = newNode;
            }
            addAfter(newNode);
        }
        size++;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> node) {
        return new Node<>(element, node);
    }

    /**
     * 平衡二叉树添加元素之后平衡的方法
     * @param node
     */
    protected void addAfter(Node<E> node) {

    }

    public boolean contains(E element) {
        return node(element) != null;
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
}
