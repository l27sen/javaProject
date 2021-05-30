package com.scotiabank.riskmanagement.testcdoe.other;

public class ReverseInt {

    public static void main(String[] a) {
        System.out.println(reverse(123));
    }

    private static int reverse(int input) {
        int result = 0;
        while (input > 0) {
            result = result * 10 + input % 10;
            input /= 10;
        }
        return result;
    }
}
