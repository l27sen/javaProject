package company.bloomberg;

import java.util.Arrays;

/**
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 * Explanation:
 * The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
 * The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
 */
public class RearrangeArrayBySign {

    public static void main(String[] a) {

        int[] nums = {3, 1, -2, -5};

        int[] result = new int[nums.length];

        int positive = 0;
        int negative = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[positive]= nums[i];
                positive = positive+2;
            } else {
                result[negative]= nums[i];
                negative= negative+2;

            }
        }
        System.out.println(Arrays.asList(result));

    }
}

