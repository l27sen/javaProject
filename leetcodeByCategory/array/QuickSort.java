package com.scotiabank.riskmanagement.testcdoe.array;

import java.util.Arrays;

public class QuickSort {


  private static void quickSort(int a[], int left, int right) {

    if (left > right) {
      return;
    }
    int i = left, j = right;
    //pivot -use the left value
    int temp = a[left];

    while (i < j) {
      i = i + 1;
      while (i <= j && a[j] > temp) {
        j--;
      }

      while (i <= j && a[i] < temp) {
        i++;
      }
      if (i < j && i <= right) {
        swap(i, j, a);
      }

    }

    // put pivot in correct place  把轴值放在中间
    swap(left, j, a);
    //partition left part
    quickSort(a, left, i - 1);
    quickSort(a, j + 1, right);

  }

  private static void swap(int i, int j, int[] arr) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }


  public static void main(String[] args) {
    int[] array = new int[]{
        14, 5, 1, 2, 15, 6, 16, 4, 9, 8, 7
    };

    quickSort(array, 0, array.length - 1);
    System.out.println("Sorted: " + Arrays.toString(array));

  }
}
