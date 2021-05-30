package com.scotiabank.riskmanagement.testcdoe.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * input is -1, 0, 1, 2, -1 -> -1,0,1 and -1, -1, 2
 */
public class ThreeNumZero {


    public static void main(String[] a) {

        int[] nums = {-1, 0, 1, 2, -1};
        List<List<Integer>> result = threeSum(nums);
        result.size();
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    //remove duplicate.
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }


        }
        return result;


    }
}
