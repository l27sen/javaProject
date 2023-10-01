package leetcodeByCategory.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.jiakaobo.com/leetcode/417.%20Pacific%20Atlantic%20Water%20Flow.html
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 */
public class PacificWater {


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List <Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0) return res;

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n - 1);
        }

        for(int j = 0; j < n; j++){
            dfs(heights, pacific, Integer.MIN_VALUE, 0, j);
            dfs(heights, atlantic, Integer.MIN_VALUE, m - 1, j);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    //visited mean the point can be reached.
    //pre is previous value of the array, i,j are index
    private void dfs(int[][] heights, boolean[][] visited, int pre, int i, int j){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) return;
        if(visited[i][j] == true) return;
        // 当前值小于之前的值，表示水被拦住了
        if(heights[i][j] < pre) return;

        visited[i][j] = true;
        dfs(heights, visited, heights[i][j], i + 1, j);
        dfs(heights, visited, heights[i][j], i - 1, j);
        dfs(heights, visited, heights[i][j], i, j - 1);
        dfs(heights, visited, heights[i][j], i, j + 1);
    }
}
