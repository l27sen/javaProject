package com.scotiabank.riskmanagement.testcdoe.string;

/**
 * cde
 * abc
 * output is 4, Remove d and e from cde to get c.Remove a and b from abc to get c.
 */
public class StringAnagrams {

    /**
     * get each char appearance times,  for for example, "aa", then a[0]=2;
     * @param inputSt
     * @return
     */
    private static int[] convertToArray(String inputSt) {
        int[] array = new int[26];

        for (int i = 0; i < inputSt.length(); i++) {
            char c = inputSt.charAt(i);
            //set the appearance time of the char
            array[c - 'a']++;
        }
        return array;
    }

    public static void main(String[] a) {

        String s1 = "cde";
        String s2 = "abc";

        int[] a1 = convertToArray(s1);
        int[] a2 = convertToArray(s2);

        int result = 0;

        for (int k = 0; k < 26; k++) {
            result += Math.abs(a1[k] - a2[k]);
        }
        System.out.println(result);
    }
}
