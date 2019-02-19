package leetcode;

public class SortArrayByBucket {

    public static void sort(int[] arrray){


        int[] sortedArray = new int[100];
        for(int i=0;i<arrray.length;i++){
            sortedArray[arrray[i]] = arrray[i];
        }

        for(int j =0;j< sortedArray.length;j++){
            if(sortedArray[j]!=0){
                System.out.println("sorted:"+ sortedArray[j]);

            }
        }
    }

    public static void main(String[] a){

        char c ='b';
        char d ='a';
        System.out.println("result:"+ (c-d));
        int[] test = {4,3,6,1,7};
        sort(test);
    }

}
