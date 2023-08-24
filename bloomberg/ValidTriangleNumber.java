package company.bloomberg;

import java.util.Arrays;

/**
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 */
public class ValidTriangleNumber {


    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);
        int res = 0;
        //从右边开始，固定右边，比较左边的两个边
        for (int i = nums.length - 1; i >= 2; i--) {

            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res = res + (right - left);
                    right--;

                } else {
                    left++;
                }
            }
        }
        return res;

    }
}
