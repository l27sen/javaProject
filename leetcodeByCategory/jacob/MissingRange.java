package leetcodeByCategory.jacob;

import java.util.*;
import java.util.Base64;

/**
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */
public class MissingRange {

    public static void main(String[] a){
        int[] nums ={0,1,3,10};
        List<String> result = findMissingRange(nums, 0, 10);
        System.out.println(result);


    }


    public static List<String> findMissingRange(int[] nums, int lower, int upper){
        List<String> result = new ArrayList<>();
        int alower = lower;

        for (int num:nums) {
            if(alower==num){
                alower++;
            }else if(alower< num){
                //begin
                if(alower+1==num){
                    result.add(String.valueOf(alower));
                }else {
                    //end
                    result.add(alower+ "->"+(num-1));
                }
                alower =num+1;

            }
        }

        if(alower==upper){
            result.add(String.valueOf(alower));
        }else if(alower<upper){
            result.add(alower+ "->"+upper);
        }

        return result;
    }
}
