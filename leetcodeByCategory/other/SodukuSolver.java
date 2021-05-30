package com.scotiabank.riskmanagement.testcdoe.other;

public class SodukuSolver {

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= 9; c++) {

                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            //also need to go to next step to ensure it works
                            if (solve(board) == true) return true;
                                //else try other node
                            else board[i][j] = '.';
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    //check valid logic from ValidSoduco
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            int sub = board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i / 3];
            if (sub != '.' && sub == c) {
                return false;
            }
        }
        return true;
    }
}
