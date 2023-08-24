package leetcodeByCategory.jacob;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SprialMatrix {


    public List<Integer> sprin(int[][] metric){


        List<Integer> res = new ArrayList<>();
        if(metric.length ==0){
            return res;
        }

        int rowBegin =0;
        int rowEnd = metric.length-1;
                int colBegin =0;
        int colEnd = metric[0].length-1;

        while (rowBegin<= rowEnd && colBegin<= colEnd){

            //left to right
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(metric[rowBegin][i]);
            }
            rowBegin++;
            //go down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(metric[i][colEnd]);
            }
            colEnd--;

            //right to left
            if(rowBegin<= rowEnd){
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(metric[rowEnd][i]);
                }
            }

            rowEnd--;


            //go up
            if(colBegin<=colEnd){
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(metric[i][colBegin]);
                }
            }
            colBegin++;

        }
        return res;
    }
}
