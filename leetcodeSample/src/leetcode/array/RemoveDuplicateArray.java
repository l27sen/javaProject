package leetcode.array;

public class RemoveDuplicateArray {

    public static void main(String[] a) {
        int[] array = {1,1,2};
        remove(array);
        array.clone();
    }

    public static int remove(int[] a) {
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if(a[i-1]!=a[i]){
                a[count++] = a[i];
            }
        }
        return count;
    }
}
