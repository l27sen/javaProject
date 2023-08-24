package leetcodeByCategory.jacob;

public class BinarySearch {

    public static int search(int[] sortedArray, int key){
       int index =-1;
        int low = 0; int high = sortedArray.length;
        while (low +1< high) {
            int mid = low  + ((high - low) / 2);
            if (sortedArray[mid] < key) {
                low = mid ;
            } else if (sortedArray[mid] > key) {
                high = mid ;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        System.out.println("low"+low);
        System.out.println("high"+high);
        return index;
    }

    public static void main(String[] a){
       int[] abc ={1,3,4,5};
        System.out.println(search(abc, 3));
    }
}
