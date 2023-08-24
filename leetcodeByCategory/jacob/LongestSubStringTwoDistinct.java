package leetcodeByCategory.jacob;

import java.util.HashMap;
import java.util.Map;

/**
 * eceba, output is 3,  ece
 */
public class LongestSubStringTwoDistinct {


    public static void main(String[] a){

        System.out.println(longest("ecebo"));
    }

    public static int longest(String s){


        Map<Character, Integer> map = new HashMap<>();

        int start =0;
        //moving pointer
        int index =0;
        int res =0;

        while (index < s.length()){

            map.put(s.charAt(index), index);
            index++;

            if(map.size()>2){

                int leftMost =s.length();
                for(int num:map.values()){
                    leftMost = Math.min(leftMost, num);
                }

                map.remove(s.charAt(leftMost));
                start = leftMost+1;
            }

        }
        res = Math.max(res, index-start);
        return res;


    }
}
