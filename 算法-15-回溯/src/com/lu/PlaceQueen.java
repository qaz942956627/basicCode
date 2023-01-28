package com.lu;

/**
 * n皇后
 *
 * @author lu
 * @date 2023/01/03
 */
public class PlaceQueen {

    public static void main(String[] args) {
        PlaceQueen placeQueen = new PlaceQueen();
        int i = placeQueen.placeQueen(8);
        System.out.printf("有%s中解法%n", i);
    }


    /**
     * index 表示行号
     * 元素值 表示列号
     */
    int[] cols;


    /**
     * 一共有多少种摆法
     */
    int count;


    public int placeQueen(int n) {

        if (n < 2) {
            return 1;
        }
        cols = new int[n];
        placeRow(0);

        return count;
    }

    public void placeRow(int row) {
        if (row == cols.length) {
            count++;
            // System.out.printf("找到第%s种摆法%n", count);
            showQueen();
            return;
        }

        for (int col = 0; col < this.cols.length; col++) {

            if (isValid(row, col)) {
                // 如果当前单元格可用则把皇后摆放在当前单元格
                this.cols[row] = col;
                // 摆放下一行
                placeRow(row + 1);
            } else {
                // 如果某一行所有的都被剪枝则当前行的栈帧结束回到上一行的栈帧
                // 上一行的栈帧会col++走到下一列继续尝试 直到placeRow(0) col=n的时候所有可能都尝试完了方法结束
                // System.out.printf("第%s行第%s列被剪枝%n", row, col);
            }
        }
    }

    private void showQueen() {
        int length = cols.length;
        for (int i = 0; i < length; i++) {
            int queen = cols[i];
            for (int j = 0; j < length; j++) {
                if (j == queen) {
                    System.out.print("*  ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    /**
     * 判断当前单元格是否有效
     *
     * @param row 行
     * @param col 列
     * @return boolean
     */
    private boolean isValid(int row, int col) {
        // 同行不需要考虑
        // 同列
        for (int i = 0; i < row; i++) {
            int col1 = cols[i];
            if (col == col1) {
                return false;
            }
        }
        // 同一斜线
        for (int i = 0; i < row; i++) {
            // 利用斜率 45度斜线的斜率为1
            // |(x1-x2)/(y1-y2)| = 1
            if (row - i == Math.abs(cols[i] - col)) {
                return false;
            }
        }
        return true;
    }

}
