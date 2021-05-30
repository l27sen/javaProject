package com.scotiabank.riskmanagement.testcdoe.array;

/**
 * 1) Divide the unsorted array into n partitions, each partition contains 1 element. Here the one
 * element is considered as sorted. 2) Repeatedly merge partitioned units to produce new sublists
 * until there is only 1 sublist remaining. This will be the sorted list at the end.
 */
public class MergeSort {


  private int[] array;
  private int[] tempMergArr;
  private int length;

  public static void main(String a[]) {

    int[] inputArr = {45, 23, 11, 89};
    MergeSort mms = new MergeSort();
    mms.sort(inputArr);
    for (int i : inputArr) {
      System.out.print(i);
      System.out.print(" ");
    }
  }

  private int[] numbers;
  private int[] helper;

  private int number;

  public void sort(int[] values) {
    this.numbers = values;
    number = values.length;
    this.helper = new int[number];
    mergesort(0, number - 1);
  }

  private void mergesort(int low, int high) {
    // check if low is smaller than high, if not then the array is sorted
    if (low < high) {
      int middle = low + (high - low) / 2;
      // Sort the left side of the array
      mergesort(low, middle);
      // Sort the right side of the array
      mergesort(middle + 1, high);
      // Combine them both
      merge(low, middle, high);
    }
  }

  //merge to two back
  private void merge(int low, int middle, int high) {

    // Copy both parts into the helper array
    for (int i = low; i <= high; i++) {
      helper[i] = numbers[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    // Copy the smallest values from either the left or the right side back
    // to the original array
    while (i <= middle && j <= high) {
      if (helper[i] <= helper[j]) {
        numbers[k] = helper[i];
        i++;
      } else {
        numbers[k] = helper[j];
        j++;
      }
      k++;
    }
    // Copy the rest of the left side of the array into the target array
    while (i <= middle) {
      numbers[k] = helper[i];
      k++;
      i++;
    }
    // Since we are sorting in-place any leftover elements from the right side
    // are already at the right position.

  }
}
