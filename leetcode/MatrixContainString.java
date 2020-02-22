package leetcode;
//矩阵中的路径
public class MatrixContainString {


        public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
            boolean[] visit = new boolean[rows*cols];
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    if(hasPath(matrix,rows,cols,i,j,str,0,visit))
                        return true;
                }
            }
            return false;
        }

        /**
                * 回溯搜索算法
     * @param matrix   输入矩阵
     * @param row      当前处理行号
     * @param col      当前处理列好
     * @param rows     矩阵行数
     * @param cols     矩阵列数
     * @param curr        已经处理str中字符串的个数
     * @param visited  访问标记数组
     * @param str      要搜索的字符串
     * @return
             */
        public boolean hasPath(char[] matrix, int rows, int cols, int row, int col, char[] str,int curr, boolean[] visit) {
            //this is the current element in the array
            int index = row*cols+col;
            if (row<0 || col<0 || row>=rows || col>=cols || visit[index] ||matrix[index]!=str[curr])
                return false;

            visit[index] = true;
            if (curr == str.length-1)
                return true;
            curr++;

            if (hasPath(matrix, rows, cols, row+1, col, str, curr, visit)||
                    hasPath(matrix, rows, cols, row-1, col, str, curr, visit)||
                    hasPath(matrix, rows, cols, row, col+1, str, curr, visit)||
                    hasPath(matrix, rows, cols, row, col-1, str, curr, visit))
                return true;

            visit[index] = false;
            return false;

        }


}
