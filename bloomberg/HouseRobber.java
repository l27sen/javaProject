package company.bloomberg;

/**
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        // 要处理两个特殊情况
        dp[0] = nums[0];
        if (nums.length == 1) return dp[0];

        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return dp[1];


        for (int i = 2; i < nums.length; i++) {
            //rob curent and i-2, or rob i-1
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
