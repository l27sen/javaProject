package leetcode;

import java.util.Arrays;

public class SortArrayByBucket {

    public static void sort(int[] array) {


        int[] sortedArray = new int[100];
        for (int i = 0; i < array.length; i++) {
            sortedArray[array[i]] = array[i];
        }


        System.out.println("sorted:" + Arrays.toString(sortedArray));


    }

    public static void main(String[] a) {

        char c = 'b';
        char d = 'a';
        System.out.println("result:" + (c - d));
        int[] test = {4, 3, 6, 1, 7};
        sort(test);
    }

}
