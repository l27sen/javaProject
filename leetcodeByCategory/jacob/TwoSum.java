package leetcodeByCategory.jacob;

import java.util.HashMap;
import java.util.Map;

/**
 * map store the array value-> index
 */
public class TwoSum {


    public int[] getSum(int[] nums, int target) {

        //key is array value, value is index
        Map<Integer,Integer> map  = new HashMap();

        for (int i = 0; i <nums.length ; i++) {


            int num = nums[i];
            int anotherValue = target-num;
            if(map.containsKey(anotherValue)){
                return new int[]{map.get(anotherValue),i};
            }
            map.put(num, i);
        }

        return null;
    }

    }


