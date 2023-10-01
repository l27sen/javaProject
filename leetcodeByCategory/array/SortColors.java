package leetcodeByCategory.array;

/**
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * 思路：
 * If nums[curr] = 0 : swap currth and p0th elements and
 * move both pointers to the right.
 * <p>
 * If nums[curr] = 2 : swap currth and p2th elements. Move
 * pointer p2 to the left.
 * <p>
 * If nums[curr] = 1 : move pointer curr to the right.
 */
public class SortColors {


    public void sortColors(int[] nums) {

        int curr = 0;
        int p0 = 0;
        int p2 = nums.length - 1;

        while (curr < p2) {

            if (nums[curr] == 0) {
                swap(nums, curr, p0);
                curr++;
                p0++;
            } else if (nums[curr] == 1) {
                p0++;
            } else {
                swap(nums, curr, p2);

                p2--;
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmpe = nums[j];
        nums[j] = nums[i];
        nums[i] = tmpe;
    }

}
