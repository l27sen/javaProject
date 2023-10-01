package leetcodeByCategory.array;

import java.util.Arrays;

/**
 * DP issue
 * Example 1:
 *
 *
 * ime complexity: O(N⋅log(N))
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * 思路：查找，然后插入最大数组
 * 变成了 【max， 2，3，7，18， max，manx，max]
 */
public class LongestIncreaseSubSeq {


    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length + 1];
        Arrays.fill(tails, Integer.MAX_VALUE);

        for(int num : nums){
            int index = helper(tails, num);
            tails[index] = num;
        }

        int res = 0;

        for(int num : tails){
            if(num != Integer.MAX_VALUE){
                res++;
            }
        }

        return res;
    }

    //找到数字要插入的位置
    private int helper(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = (start + end) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }

        //返回 end
        return end;
    }
}
