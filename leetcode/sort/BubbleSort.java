package leetcode.sort;

public class BubbleSort {


    void bubbleSort(int[] a) {

        int length = a.length;
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= length - i-1; j++) {
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
    }
}
