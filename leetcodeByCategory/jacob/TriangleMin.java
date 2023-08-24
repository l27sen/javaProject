package leetcodeByCategory.jacob;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 */
public class TriangleMin {
    public static void main(String[] args){
       List<Integer> level1 = new ArrayList<>();
        level1.add(2);
        List<Integer> level2 = new ArrayList<>();
        level2.add(3);level2.add(4);
        List<Integer> level3 = new ArrayList<>();
        level3.add(6);level3.add(5); level3.add(7);
        List<Integer> level4 = new ArrayList<>();
        level4.add(4);level4.add(1); level4.add(8);level4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(level1);
        triangle.add(level2);
        triangle.add(level3);
        triangle.add(level4);
        System.out.println(minTotal(triangle));

    }
    public static int minTotal(List<List<Integer>> triangle){
        for (int i = triangle.size()-2; i >=0 ; i--) {
            List<Integer> curr = triangle.get(i);
            //get value from next level
            for(int j =0; j<=i;j++){
                int row1Value = triangle.get(i+1).get(j);
                int row2Value = triangle.get(i+1).get(j+1);
                curr.set(j, Math.min(row1Value,row2Value)+curr.get(j));
            }

        }
        return triangle.get(0).get(0);

    }
}
