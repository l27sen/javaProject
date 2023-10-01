package leetcodeByCategory.array;

import java.util.Arrays;

/**
 * 例如在数组｛7, 5, 6, 4 中， 一共存在5 个逆序对，
 * 分别是（7, 6）、（7，5），(7, 4）、（6, 4）和（5, 4）。
 */
public class ReversePairInArray {


    public static int inversePairs(int[] data) {
        if (data == null || data.length < 1) {
            throw new IllegalArgumentException("Array arg should contain at least a value");
        }

        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);

        return inversePairsCore(data, copy, 0, data.length - 1);
    }

    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {

        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        // 前半段的最后一个数字的下标
        int i = start + length;
        // 后半段最后一个数字的下标
        int j = end;
        // 开始拷贝的位置
        int indexCopy = end;
        // 逆序数
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy] = data[i];
                indexCopy--;
                i--;
                count += j - (start + length); // 对应的逆序数
            } else {
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }

        for (; i >= start;) {
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }

        for (; j >= start + length + 1;) {
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count + left + right;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        //System.out.println(inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3};
        System.out.println(simpleSort(data2,0, data2.length-1)); //  15

    }

    /**
     * divide array to two part, then compare
     * youtube : https://www.youtube.com/watch?v=j68OXAMlTM4
     * @param num
     * @param begin
     * @param end
     * @return
     * 
     * 1,3,5,7||2,4,6,8 => 3,2) (5,2) (7,2)
     */
    private static int simpleSort(int[] num, int begin, int end){
        if(begin>= end){
            return 0;
        }
        int mid = (begin+end)/2;
        int res = simpleSort(num, begin, mid)+ simpleSort(num, mid+1, end);
        Arrays.sort(num,  begin, mid+1);
        Arrays.sort(num, mid+1, end+1);
        int i = begin;
        int j = mid+1;
        while (i<= mid && j<=end){
            if(num[i]>num[j]){
                res+=(mid-i+1);
                j++;
            }else{
                i++;
            }
        }
        return res;
    }

}
