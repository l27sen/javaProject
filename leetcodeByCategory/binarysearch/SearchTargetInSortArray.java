package com.scotiabank.riskmanagement.testcdoe.binarysearch;

/**
 * search in array like:
 * 4 5 6 0 1 2 3
 * 3 4 5 6 0 1 2
 */
public class SearchTargetInSortArray {

    public static void main(String a[]) {
        int[] num = {4, 5, 1, 2, 3};
        System.out.println(search(num, 4));
    }

    public static int search(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (a[mid] == target) return mid;
            //first case  3 4 5 6 0 1 2， first part is sorted
            if (a[start] < a[mid]) {
                if (a[start] <= target && target <= a[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            //second case 4 5 6 0 1 2 3, second part '0 1 2 3' is sorted
            else if (a[mid] < a[end]) {
                if (a[mid] <= target && target <= a[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            mid = (start + end) / 2;
        }
        return -1;
    }
}
