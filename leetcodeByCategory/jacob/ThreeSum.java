package leetcodeByCategory.jacob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            // 去重
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while(left + 1 < right && nums[left + 1] == nums[left]) left++;
                    while(right - 1 > left && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                } else if (sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}
