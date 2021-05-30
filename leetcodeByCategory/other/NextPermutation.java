package com.scotiabank.riskmanagement.testcdoe.other;

/**
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 1.1) 从右向左，找到第一个下降的数. P
 * 4 5 6 3 2 1
 * |
 * p
 * <p>
 * 2) scan from right to left, find the first element that is greater than p.
 * <p>
 * 4 5 6 3 2 1
 * |
 * q
 * <p>
 * 3) swap p and q
 * <p>
 * 4 '5 6' 3 2 1
 * swap
 * 4 '6 5' 3 2 1
 * <p>
 * 4) reverse elements [p+1, nums.length]
 * <p>
 * 4 6 1 2 3 5
 */
public class NextPermutation {


    public void nextPermutation(int[] nums) {
        //find first decreasing digit
        int first = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                first = i - 1;
                break;
            }
        }

        //if can't find , it is 5, 4,3, 2, 1,then just reverse
        if (first == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        //from right to left,
        // find the element that is greater than num[first]
        int idx = nums.length - 1;
        for (int i = nums.length - 1; i >= first + 1; i--) {
            if (nums[i] > nums[first]) {
                idx = i;
                break;
            }
        }
        //step , swap the value.
        swap(nums, first, idx);

        reverse(nums, first + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
