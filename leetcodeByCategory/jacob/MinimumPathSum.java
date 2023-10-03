package leetcodeByCategory.jacob;

/**
 *  1 3 1
 *  1 5 1
 *  2 4 1
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * O(mn)
 */
public class MinimumPathSum {

    public int min(int[][] grid){

        int col = grid[0].length;
        int row = grid.length;

        //hang， i star from 1
        for (int i = 1; i < col; i++) {
            grid[0][i]+=grid[0][i-1];
        }
        // col
        for (int j = 1; j < row; j++) {
            grid[j][0]+=grid[j-1][0];

        }

        for (int i = 1; i < col ; i++) {
            for (int j = 1; j < row; j++) {
                grid[i][j]= Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[row-1][col-1];
    }
}
