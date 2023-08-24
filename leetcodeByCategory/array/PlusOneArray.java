package leetcodeByCategory.array;

import java.util.Arrays;

public class PlusOneArray {

    public static void main(String[] a){
        int[] num ={9,9};
        int[] result = plusOne(num);
        System.out.println(result);
    }
    public static int[] plus(int[] nums){
        if(nums==null) return null;

        int carry =0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i == nums.length - 1) {
                if (nums[i] + 1 >= 10) {
                    carry = 1;
                }
                nums[i] = (nums[i] + 1) % 10;

            } else {
                if (nums[i] + carry >= 10) {
                    carry = 1;
                }else {
                    carry =0;
                }
                nums[i] = (nums[i] + carry) % 10;
            }
        }
        //carry ?0;
        if(carry> 0){
            int[] newArray = new int[nums.length+1];
            for(int i =1;i< newArray.length;i++){
                newArray[i] = nums[i-1];
            }
            newArray[0]= carry;
            return newArray;
        }
        return nums;

    }


    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }
            // here we have the rightmost not-nine
            else {
                // increase this rightmost not-nine by 1
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
