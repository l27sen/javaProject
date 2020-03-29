package leetcode.array;

public class RemoveDuplicateArray {

    public static void main(String[] a) {
        int[] array = {1, 2, 3};
        remove(array);
        array.clone();
    }

    public static int remove(int[] a) {
        int counter =0;
        for (int i = 1; i <a.length ; i++) {
            if(a[counter]!=a[i]){
                counter++;
                a[counter]=a[i];
            }

        }
        return counter+1;
    }
}
