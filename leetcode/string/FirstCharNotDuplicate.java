package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * input 'google' -> 'l'
 * input 'abbc' -> a
 */
public class FirstCharNotDuplicate {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] a) {

        String s = "google";
        System.out.println(fistLetter(s));
    }

    public static int fistLetter(String input) {

        int min = Integer.MAX_VALUE;

        int i = 0;
        for (Character c : input.toCharArray()) {

            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                //already have
                map.put(c, -1);
            }

            i++;

        }

        map.size();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() != -1) {
                min = Math.min(entry.getValue(), min);

            }
        }

        return min;

    }
}
