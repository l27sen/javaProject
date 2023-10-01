package leetcodeByCategory.other;

import java.util.Arrays;

/**
 * [1,2,0] -> return 3, array length is 3, then array should be {1,2,3}
 * [3,1,4,-1] -> return 2, array length is 4, then array should be [1,2,3,4]
 */
public class MissingPositive {


    public static void main(String[] args) {
        int[] a={2,1,0};
        System.out.println(missNumber(a));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }

    public static int missNumber(int[] num) {

        for (int i = 0; i < num.length; i++) {

            while (num[i] > 0 && num[i] < num.length && num[num[i] - 1] != num[i]) {
                //switch like bucket sort
                int temp = num[num[i] - 1];
                num[num[i] - 1] = num[i];
                num[i] = temp;
            }
        }

        //find the result for sort
        for (int i = 0; i < num.length; i++) {
            if (num[i] != i + 1) {
                return i ;
            }
        }
        return num.length + 1;


    }
}
