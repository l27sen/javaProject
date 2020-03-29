package leetcode.array;

public class maxSubArray {
    public static void main(String[] args)
    {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        int max_sum = maxSubArraySum(a, n);
        System.out.println("Maximum contiguous sum is "
                + max_sum);
    }

    static int maxSubArraySum(int a[],int size)
    {

        int maxResult = 0, currentMax = 0;

        for (int i = 0; i < size; i++)
        {
           currentMax +=a[i];
           if(currentMax<0){
               currentMax =0;
           }else if(maxResult<currentMax){
               maxResult = currentMax;
           }

        }
        return maxResult;
    }
}
