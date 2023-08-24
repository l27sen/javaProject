package leetcodeByCategory.jacob;

public class Metric2DSearch {

    public boolean search(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            int value = matrix[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value < target) {
                start = mid;
            } else {
                end = mid;
            }

        }

        if (matrix[start / col][start % col] == target) {
            return true;
        } else if (matrix[end / col][end % col] == target) {

        }


        return false;
    }

    boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;  // number of coloumns

        while(i<matrix.length && j>=0)
        {
            if(target==matrix[i][j])
                return true;
            else if(target<matrix[i][j])
                j--;
            else
                i++;
        }
        return false;
    }
}
