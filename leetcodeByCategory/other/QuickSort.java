package leetcodeByCategory.other;

public class QuickSort {

  public static void main(String[] a) {
    int[] array = {3, 2, 4, 5, 7};
    quickSort(array, 0, 4);
    array.toString();
  }


  public static void quickSort(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0) {
      return;
    }

    if (low >= high) {
      return;
    }

    // pick the pivot
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];

    // make left < pivot and right > pivot
    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    // recursively sort two sub parts
    if (low < j) {
      quickSort(arr, low, j);
    }

    if (high > i) {
      quickSort(arr, i, high);
    }
  }
}
