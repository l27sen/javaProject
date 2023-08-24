package leetcodeByCategory.array;

/**
 *
 *
 *  1 2 3
 *  4 5 6
 *  7 8 9
 *
 *  first step , go to this:
 *  1 4 7
 *  2 5 8
 *  3 6 9
 *
 *  then , go to
 *  7 4 1
 *  8 5 2
 *  9 6 3
 *
 *  O(M) time
 */
public class MetrixRotate {

  public void rotate (int[][] matrix){

    int N = matrix.length;

    //step 1 对角线互换
    for (int i = 0; i < matrix.length; i++) {
      //todo why j=i
      for (int j = i; j < N; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < N/2; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[row][N-1-col];
        matrix[row][N-1-col] = temp;
      }
    }

  }

}
