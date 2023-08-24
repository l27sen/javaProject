package company.bloomberg;

/**
 * Input: nums = [3,4,2]
 * Output: 6
 * Explanation: You can perform the following operations:
 * - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
 * - Delete 2 to earn 2 points. nums = [].
 * You earn a total of 6 points.
 * Example 2:
 * <p>
 * Input: nums = [2,2,3,3,3,4]
 * Output: 9
 * Explanation: You can perform the following operations:
 * - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
 * - Delete a 3 again to earn 3 points. nums = [3].
 * - Delete a 3 once more to earn 3 points. nums = [].
 * You earn a total of 9 points.
 * <p>
 * <p>
 * convert:
 * 思路： 转化数组，然后用 House robbery算法
 * [3,4,2]->[0,2,3,4]-> rob [0 2 3 4] = 6;
 * [2 2  3 3 3 4] -> rob [ 0 2*2, 3*3, 4] =9
 */
public class DeleteAndEarn {

    public static void main(String[] a){
        int[] num ={2,2,3,3,3,4};
        System.out.println(deleteAndEarn(num));
    }

    public static  int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        //get max num
        int[] counts = new int[max+1];
        //change to rob array,
        for (int num : nums)
            counts[num]++;
        //use house robbery.
        int[] dp = new int[max + 1];
        dp[1] = counts[1];
        dp[2] = Math.max(dp[1], 2 * counts[2]);
        for (int i = 3; i <= max; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * counts[i]);
        return dp[max];
    }


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
