package com.scotiabank.riskmanagement.testcdoe.array;

// step 1, check one by  one from [0,0]
// step 2, dfs 函数参数， array, inputString, i, j, indexLength
// indexLength 代表要比较的InputString的第几位字符
//   dfs 里面recursion
public class ArrayContainStringPath {

  public static void main(String[] a) {
    char[][] board = {
        {'a', 'b','c'},
        {'d', 'e','f'},
        {'k', 'h','j'}
    };

    System.out.print(exist(board, "ehj"));
  }


  public static boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, word, i, j, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   *
   * @param board
   * @param word
   * @param i
   * @param j
   * @param indexLength start from 0.
   * @return
   */
  public static boolean dfs(char[][] board, String word, int i,
      int j, int indexLength) {
    int m = board.length;

    int n = board[0].length;

    //border check
    if (i < 0 || j < 0 || i >= m || j >= n) {
      return false;
    }

    //check current char value
    if (board[i][j] == word.charAt(indexLength)) {
      //char temp = board[i][j];
      //board[i][j] = '*';
      if (word.length() - 1 == indexLength) {
        return true;
      } else {
        if (dfs(board, word, i - 1, j, indexLength + 1) || dfs(board, word, i + 1, j,
            indexLength + 1)
            || dfs(board, word, i, j - 1, indexLength + 1) || dfs(board, word, i, j + 1,
            indexLength + 1)) {
          return true;
        }
      }
      //回溯 好像也可以
      //board[i][j] = temp;
    }

    return false;
  }

}
