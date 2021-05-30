package com.scotiabank.riskmanagement.testcdoe.binarysearch;

public class FindNumInRotatedArray {
    public static void main(String[] args) {
        int[] a = {6, 7, 1, 2, 3, 4, 5};
        System.out.println(minNumberRotateArray(a));

    }

    public static int minNumberRotateArray(int[] array) {
        // 日常判断
        if (array.length == 0)
            return 0;

        int begin = 0;
        int end = array.length - 1;

        while (begin < end) {
            int mid = (end - begin) / 2 + begin;

            //sepcial point
            if (mid > 0 && array[mid] < array[mid - 1]) {
                return array[mid];
            } else if (array[begin] < array[mid] && array[mid] > array[end]) {
                // 3,4,5,6,1,2
                begin = mid + 1;
            } else {
                end = mid - 1;
                //5,6,1,2,3,4,
            }

        }
        return array[begin];
    }

    public  int search(int[] a, int target){

        int left =0;
        int right = a.length -1;
        //find the
        while (left< right){

            int mid = left+(right-left)/2;
            if(a[mid]>a[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        //keep the pivot
        int start = left;
        left =0;
        right = a.length-1;
        //set the search point
        if(target>=a[start] && target<= a[right]){
            left = start;
        }else {
            right = start;
        }

        while (left<=right){
            int mid = left+(right-left)/2;
           if(a[mid]==target){
               return mid;
           }else if(a[mid]> target){
               right = mid -1;
           }else {
               left = mid+1;
           }
        }

        return -1;
    }

}
