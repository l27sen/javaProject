package com.scotiabank.riskmanagement.testcdoe.array;

/*
例如输入排序数组｛ 1, 2, 3, 3, 3, 3, 4, 5｝和数字3 ，由于3 在这个数组中出现了4 次，因此输出4 。

 */
public class AppearanceNumInSortArray {

    public static void main(String[] args){
        int[] a = {1,2,3,3,3,4,5};
        System.out.println(getFirstValue(a,3,0,7));
    }

    private static int getFirst(int[] data, int inputNum, int start, int end){
        if(data ==null ||start>end){
            return -1;
        }
        int mid = (start+end)/2;

        if (data[mid] == inputNum) {
            if (mid > 0 && data[mid - 1] != inputNum || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }


        } else if (data[mid] > inputNum) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirst(data, inputNum, start, end);
    }


    public static int getFirstValue(int arr[],int key, int first, int last ){
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr[mid] < key ){
                first = mid + 1;
            }else if ( arr[mid] == key ){
                if (mid > 0 && arr[mid - 1] != key || mid == 0) {
                    return mid;
                } else {
                    last = mid - 1;
                }
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        return -1;
    }
}
