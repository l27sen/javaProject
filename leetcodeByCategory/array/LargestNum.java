package leetcodeByCategory.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 思路： 用 comparator 比较
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNum {

    public static void main(String[] a){
        int[] num ={3,30,34,5,9};
        System.out.println(sort(num));
    }

    public static int sort(int[] num){

        String[] strings = new String[num.length];

        for (int i = 0; i < num.length; i++) {
            strings[i]= Integer.valueOf(num[i]).toString();
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        };

        Arrays.sort(strings, comparator);

        StringBuilder stringBuilder = new StringBuilder();

        for(String value:strings){
            stringBuilder.append(value);
        }

        return Integer.parseInt(stringBuilder.toString());

    }
}
