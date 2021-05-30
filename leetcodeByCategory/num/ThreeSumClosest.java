package com.scotiabank.riskmanagement.testcdoe.num;

import java.util.Arrays;

/**
 * [-1,2,1,4] , if target is 1, tehn result is [-1,2,1]
 */
public class ThreeSumClosest {

    public int threeSum(int[] a, int target) {
        int result = a[0] + a[1] + a[a.length - 1];
        Arrays.sort(a);
        for (int i = 1; i < a.length - 2; i++) {

            int start = i + 1, end = a.length - 1;
            while (start < end) {
                int sum = a[i] + a[start] + a[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }

            }

        }

        return result;
    }
}
