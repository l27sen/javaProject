package leetcode.array;

public class SearchInsertPosition {
    public static void main(String a[]) {
        int[] num = {1,3,4,8};
        System.out.println(search(num, 5));
    }

    public static int search(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (a[mid] == target) return mid;
            //first case  3 4 5 6 0 1 2， first part is sorted
            if (a[mid] < target) {
              start =mid+1;
            }
            else{
                end = mid -1;
            }
            mid = (start + end) / 2;
        }
        if(start>=end){
            return end+1;
        }
        if( target<=a[start]){
            return start;
        }else if (target<= a[end]){
            return end;
        }else {
            return end+1;
        }
    }

}
