package com.scotiabank.riskmanagement.testcdoe.graphic;

public class Islands {

  static final int ROW = 5, COL = 5;


  // The main function that returns count of islands in a given
  // boolean 2D matrix
  int countIslands(int M[][]) {

    int count = 0;
    for (int i = 0; i < ROW; ++i) {
      for (int j = 0; j < COL; ++j) {
        if (M[i][j] == 1) // If a cell with
        { // value 1 is not
          // visited yet, then new island found, Visit all
          // cells in this island and increment island count
          callDFS(M, i, j);
          ++count;
        }
      }
    }

    return count;
  }

  //周边的都设置成0
  public void callDFS(int[][] grid, int i, int j) {

    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
      return;
    }
    grid[i][j] = 0;
    callDFS(grid, i + 1, j);
    callDFS(grid, i - 1, j);
    callDFS(grid, i, j + 1);
    callDFS(grid, i, j - 1);

  }

  // Driver method
  public static void main(String[] args) throws java.lang.Exception {
    int M[][] = new int[][]{{1, 1, 0, 0, 0},
        {1, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}};
    Islands I = new Islands();
    System.out.println("Number of islands is: " + I.countIslands(M));
  }
}
