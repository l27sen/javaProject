package com.scotiabank.riskmanagement.testcdoe.dp;

/**
 * Input: nums = [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then rob house 3
 * (money = 3). Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {

  public static void main(String[] a){
    int[] abc = {1,2,3,1};

    System.out.println(rob(abc));
  }
  public static int rob(int[] nums) {

    int[] dp = new int[nums.length];

    dp[0] = nums[0];

    if (nums.length == 1) {
      return dp[0];
    }

    dp[1] = Math.max(nums[0], nums[1]);

    if (nums.length == 2) {
      return dp[1];
    }

    for (int i = 2; i < nums.length; i++) {

      //两种选择 i and i-2, 或者 i-1
      dp[i] = Math.max(nums[i] + dp[2], dp[i - 1]);
    }

    return dp[nums.length - 1];
  }


}
