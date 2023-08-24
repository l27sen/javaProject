package leetcodeByCategory.array;

/**
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 */
public class RotateArray {

    public void rotate(int[] nums, int k){
        if(k> nums.length){
            k = k%nums.length;
        }
        int a = nums.length - k;
        reverse(nums, 0, a-1);
        reverse(nums, a, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public void reverse(int[] nums, int left, int right){
        if(nums==null ||nums.length==1) return;


        while(left< right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
