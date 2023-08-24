package leetcodeByCategory.jacob;

public class UniquePath {

    public static int unique(int row, int col){
        int[] dp = new int[row];

        for (int i = 0; i < row ; i++) {
            dp[i]=1;
        }

        for (int j = 1; j < col ; j++) {

            for (int i = 1; i < row; i++) {
                dp[i]= dp[i]+dp[i-1];
            }
        }

        return dp[row-1];
    }

    public static void main(String[] a){
        System.out.println(unique(3,3));
    }


    public int uniquePaths(int m, int n) {
        int count[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            count[i][0] = 1;
        for (int j = 0; j < n; j++)
            count[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                count[i][j] = count[i - 1][j] + count[i][j - 1];
        }
        return count[m - 1][n - 1];
    }

}
