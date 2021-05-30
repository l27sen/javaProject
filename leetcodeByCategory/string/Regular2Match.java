package com.scotiabank.riskmanagement.testcdoe.string;

/**
 *
 * first match,  s.charAt(0) == p.charAt(0) || p.charAt(0)= '.'
 * check rest
 *   if second char is  *,
 *         1) use * as 0 times, isMatch(s, p.subString(2), example:
 *                                                         aab c*a*b ->true, c* can be empty
 *         2) use * multiple times, firstMatch && isMatch(s.subString(1), p)
 *            example, "aaaa" with "a*",
 *
 *   else second is not *
 *     firstmatch && isMatch(s.subString(1), p.subString(1));
 */
public class Regular2Match {

    /**
     * aab c*a*b ->true, c* can be empty
     * ab  and .* ->true
     * aa and a* ->true
     * @param a
     */
    public static void main(String[] a) {
        //System.out.println(isMatch("aa", ".a"));
        System.out.println(isMatch("aaa", "a*"));
    }

    public static boolean isMatch(String s, String p) {
        // base case
        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // aab c*a*b ->true || aaa with a*
            return isMatch(s, p.substring(2)) || (isMatch(s.substring(1), p) && firstMatch);
        } else {
            //regular case
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

    }
}
