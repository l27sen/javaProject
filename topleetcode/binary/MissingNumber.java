package topleetcode.binary;

/**
 * Input: [3,0,1]
 Output: 2
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.


 */
public class MissingNumber {

    public static void main(String[] args)
    {
        System.out.println("xor "+(1^1));
        int a[] = {0,1,3};
        int mssingNum = missingNumber(a);
        System.out.println("missing number is "
                + mssingNum);
    }

    public  static int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
            //below is easier to understand
            //if missing is 3, i is 2, number [2] is 3,
            // 3^2^3, then to 2
            missing = missing^i^nums[i];
        }
        return missing;
    }
}
