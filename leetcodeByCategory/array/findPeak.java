package leetcodeByCategory.array;

/**
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */
public class findPeak {

    public static void main(String[] a){
        int[] arr ={1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));

    }

    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        //l<=r, find the mid
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid-1;
            else
                l = mid + 1;
        }
        return l;
    }
}
