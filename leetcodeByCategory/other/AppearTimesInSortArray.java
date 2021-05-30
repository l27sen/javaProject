package com.scotiabank.riskmanagement.testcdoe.other;

public class AppearTimesInSortArray {

  public static void main(String[] a) {
    int[] array = {2, 3, 3, 3, 4};
    System.out.println(findFirstAppearance(array, 3));
    System.out.println("last:"+findLastAppearance(array, 3));

  }

  public static int findTimes(int[] a) {
    return 0;
  }

  private static int findFirstAppearance(int[] a, int key) {
    int begin = 0;
    int end = a.length - 1;

    while (begin < end) {
      int mid = begin + (end - begin) / 2;
      if (a[mid] == key) {
        if (mid - 1 > 0 && a[mid - 1] != key || mid == 0) {
          return mid;
        } else {
          end = mid - 1;
        }
      } else if (a[mid] > key) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }

    }
    return begin;

  }


  private static int findLastAppearance(int[] a, int key) {
    int begin = 0;
    int end = a.length - 1;

    while (begin < end) {
      int mid = begin + (end - begin) / 2;
      if (a[mid] == key) {
        if (mid + 1 <= a.length-1 && a[mid + 1] != key || mid == a.length-1) {
          return mid;
        } else {
          begin = mid + 1;
        }
      } else if (a[mid] > key) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }

    }
    return begin;

  }

}
