package leetcodeByCategory.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {


    public static void main(String[] a){
        NQueen nQueen = new NQueen();
        List<List<String>> result = nQueen.solve(4);
        result.forEach(s->System.out.println(s));
    }

    public List<List<String>> solve(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        init(board);
        helper(result, board, 0);
        return result;

    }

    private void init(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    private void helper(List<List<String>> result, char[][] board, int rowIndex) {

        if (rowIndex == board.length) {
            result.add(generate(board));
            return;
        }
        for (int colIndex = 0; colIndex < board.length; colIndex++) {
            if (isValid(board,rowIndex,colIndex)) {
                board[rowIndex][colIndex] = 'Q';
                helper(result, board, rowIndex + 1);
                board[rowIndex][colIndex] = '.';
            }

        }

    }

    private boolean isValid(char[][] board, int row, int col) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //左上判断
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }


        return true;
    }

    private List<String> generate(char[][] board) {
        List<String> list = new ArrayList();
        for (char[] row : board) {
            StringBuffer sb = new StringBuffer();
            for (char c : row) {
                sb.append(c);
            }
            list.add(sb.toString());
        }
        return list;
    }


}
