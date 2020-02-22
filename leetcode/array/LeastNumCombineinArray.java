package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 例如输入数组{3， 32, 321}，则扫描输出这3 个数字能排成的最小数字321323。
 * 根据题目的要求，两个数字m 和n能拼接成数字m和m。如果mn < nm，
 * 那么我们应该打印出m，也就是m 应该排在n 的前面，我们定义此时m 小于n：反之，如果nm < mn，我们定义n小于m。如果mn=nm,m 等于n。在下文中，符号“<”、“>”及“＝”表示常规意义的数值的大小关系，而文字“大于”、“小于”、“等于”表示我们新定义的大小关系

 */
public class LeastNumCombineinArray {

    /**
     * 自定义的排序比较器，实现算法说明的排序原理
     */
    private static class MComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {

            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("Arg should not be null");
            }

            String s1 = String.valueOf(o1) + String.valueOf(o2);
            String s2 = String.valueOf(o2) + String.valueOf(o1);
            return s1.compareTo(s2);
        }
    }


    private static void quickSort(int a[], int left, int right, MComparator comparator) {

        if (left > right) {
            return;
        }
        int i = left, j = right;
        //pivot -use the left value
        int temp = a[left];

        while (i < j) {
            //plus one to avoid i equals pivot value.
            i=i+1;
            while (i <= j && comparator.compare(a[j],temp) >= 0 ) {
                j--;
            }
            while (i <= j && comparator.compare(a[i],temp)<=0) {
                i++;
            }
            if (i < j && i <= right) {
                swap(i,j,a);
            }

        }


        // put pivot in correct place  把轴值放在中间
        swap(left,j,a);


        //partition left part
        quickSort(a, left, i-1, comparator);
        quickSort(a, j+1, right, comparator);

    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args){
        int[] array = new int[] {
                14, 5,94
        };
        MComparator comparator = new MComparator();

        quickSort(array,0, array.length-1, comparator);
        System.out.println("Sorted: " + Arrays.toString(array));

    }
}
