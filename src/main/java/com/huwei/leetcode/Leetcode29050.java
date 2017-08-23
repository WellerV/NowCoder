package com.huwei.leetcode;

/**
 * 题目描述

 Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 A region is captured by flipping all'O's into'X's in that surrounded region .
 For example,
 X X X X
 X O O X
 X X O X
 X O X X

 After running your function, the board should be:
 X X X X
 X X X X
 X X X X
 X O X X
 *
 */
public class Leetcode29050 {
    private static final int TOP = 1;
    private static final int RIGHT = 2;
    private static final int BOTTOM = -1;
    private static final int LEFT = -2;
    private int row;
    private int col;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        row = board.length;
        col = board[0].length;
        for (int i=1; i< row-1; i++) {
            //右边
            if (board[i][col-1] == 'O') {
                travel(board, col-1, i, LEFT);
            }

            //左边
            if (board[i][0] == 'O') {
                travel(board, 0, i, RIGHT);
            }
        }

        for (int i=1; i<col-1; i++) {
            //顶部
            if (board[0][i] == 'O') {
                travel(board, i, 0, BOTTOM);
            }

            //下面
            if (board[row-1][i] == 'O') {
                travel(board, i, row-1, TOP);
            }
        }

        for (int i=1; i< row-1; i++)
            for (int j=1; j < col-1; j++) {
                if (board[i][j] == 'S')  board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
    }

    //direction top 0 right 1 bottom 2 left 3
    private void travel(char[][] board, int x, int y, int direction) {
        switch (direction) {
            case TOP:
                y--;
                break;
            case RIGHT:
                x++;
                break;
            case BOTTOM:
                y++;
                break;
            case LEFT:
                x--;
                break;
        }
        //位置有效
        if (x > 0 && x < col-1 && y>0 && y<row-1) {
            if (board[y][x] == 'O') {
                board[y][x] = 'S';

                for (int dir = 1; dir <= 2; dir ++) {
                    if(dir != -direction) travel(board, x, y, dir);
                }

                for (int dir = -1; dir >= -2; dir --) {
                    if(dir != -direction) travel(board, x, y, dir);
                }
            }
        }
    }
}