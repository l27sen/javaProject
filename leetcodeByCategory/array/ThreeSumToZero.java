package com.scotiabank.riskmanagement.testcdoe.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumToZero {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(a));

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j<k){
                if(nums[i]+nums[j]+nums[k]>0){
                   k--;
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }


        return result;
    }
}
