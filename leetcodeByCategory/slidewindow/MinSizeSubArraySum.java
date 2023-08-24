package leetcodeByCategory.slidewindow;

/**
 * given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2
 * TODO
 */
public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 1};
        System.out.println(minSubArrayLen2(7, a));
    }


    /**
     * We can use 2 points to mark the left and right boundaries of the sliding window.
     * When the sum is greater than the target, shift the left pointer;
     * when the sum is less than the target, shift the right pointer.
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        int j = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;

        while (j < nums.length) {

            if (sum < s) {
                sum = sum + nums[j];
                j++;
            } else {
                minLen = Math.min(minLen, j - i);
                if (i == j - 1)
                    return 1;
                sum = sum - nums[i];
                i++;
            }

        }
        //need this logic, if the last number is super big
        while (sum >= s) {
            minLen = Math.min(minLen, j - i);
            sum -= nums[i++];
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static int minSubArrayLen2(int target, int[] nums) {
        int result =Integer.MAX_VALUE;

        int sum =0;
        int left =0;

        //left and i will be the windows
        for (int i = 0; i < nums.length; i++) {
            sum = sum+ nums[i];
            while (left<=i && sum>=target){
                result = Math.min(result, i-left+1);
                sum = sum- nums[left];
                left++;
            }
        }
        return result;
    }

    }
