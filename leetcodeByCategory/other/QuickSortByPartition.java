package com.scotiabank.riskmanagement.testcdoe.other;

import java.util.Arrays;

public class QuickSortByPartition {

    public static void quickSort(int[] array) {
        //quick(array, 0, array.length - 1);

        //this way works as wel
        quick_sort(array, 0, array.length - 1);
    }


    public  static void quick_sort(int intArray[], int low, int high) {
        if (low < high) {
            //partition the array around pi=>partitioning index and return pi
            int pi = partition2(intArray, low, high);

            // sort each partition recursively
            quick_sort(intArray, low, pi-1);
            quick_sort(intArray, pi+1, high);
        }
    }

    private static int partition2(int[] input, int start, int end) {
        //partition value in each round
        int tmp = input[start];
        while (start < end) {
            //find right value smaller than partition value
            while (start < end && input[end] >= tmp) {
                end--;
            }
            // 把右边的值交换到左边
            input[start] = input[end];
            //find left value bigger than tmp.
            while (start < end && input[start] <= tmp) {
                start++;
            }

            //左边的值交换到右边
            input[end] = input[start];
        }
        //here set the pivot value to middle
        input[start] = tmp;
        return start;
    }



    public static void quick(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        if (left < index - 1) {
            quick(array, left, index - 1);
        }
        if (index < right) {
            quick(array, index, right);
        }


    }

    private static int partition(int[] array, int left, int right, int pivot) {

        //pay attention, here is <=
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }

        }
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] array = new int[]{
                14, 5, 1, 2, 15, 6, 16, 4, 9, 8, 7
        };

        quickSort(array);
        System.out.println("Sorted: " + Arrays.toString(array));
    }
}
