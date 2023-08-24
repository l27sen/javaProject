package leetcodeByCategory.jacob;

import java.util.HashMap;
import java.util.Map;

/**
 * For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
 *
 * For “BBBB” the longest substring is “B”, with length 1.
 *
 * 思路： two pointer 和 hashmap， value =  i -left+1。
 */
public class LongestStringWithoutRepeat {

    public static void main(String[] a){
        System.out.println(longest("ABDEFGABEF"));
    }

    public static int longest(String s){


        Map<Character, Integer> map = new HashMap<>();

        int start =0;
        //moving pointer
        int left =0;
        int res =1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                //关键，重复位置+1，和当前位置, left always move to right.
                left = Math.max(left, map.get(c)+1);
            }
            if(i -left +1> res){
                res = i-left+1;
            }
            map.put(c, i);
            
        }
        return res;


    }
}
