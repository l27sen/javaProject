package leetcodeByCategory.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum3 {

    private HashMap <Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum3() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num1 = entry.getKey();
            //rest value
            int comp = value - num1;
            if((num1 == comp) && entry.getValue() > 1
                    || (num1 != comp) && map.containsKey(comp)){
                return true;
            }
        }

        return false;
    }
}
