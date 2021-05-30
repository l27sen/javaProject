package com.scotiabank.riskmanagement.testcdoe.other;

public class RemoveDuplicateArray {

  public static void main(String[] a) {
    int[] array = {1, 2, 2, 3, 3};
    System.out.println(removeDuplicates(array));
    array.toString();
  }

  public static int removeDuplicates(int[] A) {
    if (A.length < 2) {
      return A.length;
    }

    int i = 0;
    int j = 1;

    while (j < A.length) {
      if (A[i] != A[j]) {
        i++;
        A[i] = A[j];
      }

      j++;
    }

    return i + 1;
  }
}
