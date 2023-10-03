package leetcodeByCategory.num;

import java.util.HashMap;
import java.util.Map;

/**
 * except for when a smaller valued symbol is before a larger valued symbol. In those cases,
 * instead of adding both symbols to the total, we need to subtract the large from the small, adding that instead
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInteger {

    public static void main(String[] a) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int length = s.length();
        int result = romanValues.get(s.charAt(0));

        for (int i = 1; i <= length - 1; i++) {
            //如果 右边的比左边的大
            if (romanValues.get(s.charAt(i)) <= romanValues.get(s.charAt(i - 1))) {
                result += romanValues.get(s.charAt(i));
            } else {
                result -= romanValues.get(s.charAt(i));
            }
        }


        return result;
    }

    public int romanToInt2(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = romanValues.get(currentSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = romanValues.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            }
            else {
                sum += currentValue;
                i += 1;
            }

        }
        return sum;
    }
}
