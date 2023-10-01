package leetcodeByCategory.array;

/**
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {


    public static void main(String[] a) {
        int[] nums = {2,2,1,1,1,4};
        System.out.println(getMajor(nums));
    }
    public static int getMajor(int[] nums){

        int res =0;
        int count =0;

        //if count is 0, change to current num, because majority num is more, it the num is the res
        //如果当前结果不相等，就  --， 否则 相等就++
        for(int num: nums){
            if(count ==0 ){
                res =num;
            }
            if(res!=num){
                count--;
            }else {
                count++;
            }
        }

        return res;
    }
}
