package com.lu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 小卢
 * @version 1.0
 * @date 2023/1/26 19:08
 **/
public class SolveNQueens {

    public static void main(String[] args) {
        int lists = new SolveNQueens().solveNQueens(8);
        System.out.println("一共"+lists+"种解法");
    }

    int count = 0;


    int solveNQueens(int n) {

        int[][] board = new int[n][n];
        backtrack(board, 0);
        return count;
    }

    private void backtrack(int[][] board, int row) {
        int length = board.length;
        if (row == length) {
            // 找到一种解法
//            allRes.add(board);
            count++;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("-----------------------------");
            return;
        }
        for (int col = 0; col < length; col++) {
            // 排除不合法选项
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 1;
            backtrack(board, row + 1);
            // 还原选择
            board[row][col] = 0;
        }

    }

    private boolean isValid(int[][] board, int row, int col) {

        // 判断同一列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // 判断左上
        for (int i = row - 1, j = col - 1; i >= 0 & j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 判断右上
        for (int i = row - 1, j = col + 1; i >= 0 & j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
