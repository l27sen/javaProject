package com.scotiabank.riskmanagement.testcdoe.array;

import java.util.Arrays;

public class QuickSortByPartition {

    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
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
