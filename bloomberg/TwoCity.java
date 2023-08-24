package company.bloomberg;

import java.util.Arrays;
import java.util.Comparator;

//sort by difference of the array value， how much we will benefit go to A ranther than cityB
public class TwoCity {


    public int twoCitySchedCost(int[][] costs) {

       int result =0;
       // Sort by a gain which company has
        // by sending a person to city A and not to city B
        Arrays.sort(costs, new Comparator<int[]>() {

            public int compare(int[] a1, int[]a2){

                return a1[0] - a1[1] - (a2[0] - a2[1]);
            }
        });
        
        int n = costs.length/2;
        for (int i = 0; i < n; i++) {
            result = result+ costs[i][0];
        }
        for (int i = n; i < costs.length; i++) {
            result = result+ costs[i][1];
        }

        return result;
    }
}
