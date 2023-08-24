package leetcodeByCategory.jacob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static void main(String[] a){
        int[][] intervals = {{1,3},{3,4},{5,7}};
        int[][] result = merge(intervals);
        System.out.println(result.length);
    }

    public static int[][] merge(int[][] intervals){
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        //get the first
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                //set the max index 1 value of two array
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                //[2,4] [5,7] case,
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][2]);
    }
}
