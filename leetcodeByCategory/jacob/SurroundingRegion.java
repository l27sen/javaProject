package leetcodeByCategory.jacob;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * nput: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Notice that an 'O' should not be flipped if:
 * - It is on the border, or
 * - It is adjacent to an 'O' that should not be flipped.
 * The bottom 'O' is on the border, so it is not flipped.
 * The other three 'O' form a surrounded region, so they are flipped.
 */
public class SurroundingRegion {

    public void resovle(char[][] board) {


        //row
        int m = board.length - 1;
        int n = board[0].length - 1;

        //first and last row
        for (int j = 0; j <= n; j++) {

            if (board[0][j] == '0') {
              helper(board, 0,j);
            }

            if (board[m][j] == '0') {
                helper(board, m,j);

            }
        }


        for (int i = 0; i <= m; i++) {

            if (board[i][0] == '0') {
                helper(board, i,0);

            }

            if (board[i][n] == '0') {
                helper(board, i,n);

            }
        }
    }

    public void helper(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || (j < 0 || j >= board[0].length) || (board[i][j]) != '0') return;
        board[i][j] = '#';
        helper(board, i - 1, j);
        helper(board, i + 1, j);
        helper(board, i, j - 1);
        helper(board, i, j + 1);
    }
}
