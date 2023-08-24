package leetcodeByCategory.array;


//Time complexity : O(M)\mathcal{O}(M)O(M)
public class RotateImage {

    public void rotate(int[][] matrix){

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        //对角线
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        //左边到右边
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][colLength-j-1];
                matrix[i][colLength-j-1] = temp;
            }
        }
    }

}
