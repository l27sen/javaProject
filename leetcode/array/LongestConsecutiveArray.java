package leetcode.array;

import java.util.HashSet;

/**
 * [100, 4, 200, 1, 3, 2],
 * the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.
 */
public class LongestConsecutiveArray {

    public static void main(String[] a){
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        int result = 0;

        //针对每个数，向上或者向下加减
        for(int num: nums){
            int count = 1;
            int down = num-1;
            while(set.contains(down)){
                set.remove(down);
                down--;
                count++;
            }

            int up = num+1;
            while(set.contains(up)){
                set.remove(up);
                up++;
                count++;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
