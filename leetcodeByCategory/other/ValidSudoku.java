package leetcodeByCategory.other;

import java.util.HashSet;
import java.util.Set;

/**
 * 数独， 横行，竖行， 格子都不重复
 */
public class ValidSudoku {


    //leetcode
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }

    //Time complexity: O(N2), space O(n2)
    //(r/3) * 3 + (c/3) is used calculate a number in the range from 0 to 8
    public static boolean isValid(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int col = 0; col < board[0].length; col++) {
                //判断横行
                if (board[row][col] != '.' && !rows.add(board[row][col])) {
                    return false;
                }
                //判断竖行
                if (board[col][row] != '.' && !cols.add(board[col][row])) {
                    return false;
                }

                //cube
                // 0 0 0 3 3 3 6 6 6
                int rowIndex = 3 * (row / 3);
                // 0 3,6 0, 3, 6, 0,3,6
                int colIndex = 3 * (row % 3);

                //col /3: 000, 111, 222
                //col %3, 0 1 2, 0 1 2 , 0 1 2

                //board[rowIndex+col/3][colIndex+col%3] 代表每个元素
                if (board[rowIndex + col / 3][colIndex + col % 3] != '.' && !cube.add(board[rowIndex + col / 3][colIndex + col % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param board
     * @param i
     * @param j
     * @return
     */
    public static boolean isValid2(char[][] board, int i, int j) {

        for (int row = 0; row < board.length; row++) {
            if (board[row][j] == board[i][j] && row != i) return false;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (board[i][col] == board[i][j] && col != j) return false;
        }

        // 0,1,2-> start value is 0,0,0 to 3,3,3, 3,4,5 -> 3 ,3,3 to 6,6, 6
        for (int row = (i / 3) * 3; row < (i / 3 + 1) * 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3 + 1) * 3; col++) {
                if (row == i && col == j) continue;
                if (board[row][col] == board[i][j]) {
                    return false;
                }
            }

        }

        return true;


    }

}
