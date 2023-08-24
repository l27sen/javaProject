package company.bloomberg;

/**
 *
 * xample:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 思路 从边线开始， 如果是0，那么往里面 设置 #
 */
public class SurroundedRegion {


    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length - 1;
        int n = board[0].length - 1;

        for(int j = 0; j <= n; j++){
            if(board[0][j] == 'O'){
                helper(board, 0, j);
            }

            if(board[m][j] == 'O'){
                helper(board, m, j);
            }
        }

        for(int i = 0; i <= m; i++){
            if(board[i][0] == 'O'){
                helper(board, i, 0);
            }

            if(board[i][n] == 'O'){
                helper(board, i, n);
            }
        }

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void helper(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;

        //if value is '0' , then set to '#'
        board[i][j] = '#';
        helper(board, i + 1, j);
        helper(board, i - 1, j);
        helper(board, i, j + 1);
        helper(board, i, j - 1);
    }
}
