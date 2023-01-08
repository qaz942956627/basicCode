package lu.printer;

/**
 * 打印
 *
 * @author 小卢
 * @date 2023/01/07
 */
public abstract class Printer {
    /**
     * 二叉树的基本信息
     */
    protected BinaryTreeInfo tree;

    public Printer(BinaryTreeInfo tree) {
        this.tree = tree;
    }

    /**
     * 生成打印的字符串
     *
     * @return {@link String}
     */
    public abstract String printString();

    /**
     * 打印后换行
     */
    public void println() {
        print();
        System.out.println();
    }

    /**
     * 打印
     */
    public void print() {
        System.out.print(printString());
    }
}
