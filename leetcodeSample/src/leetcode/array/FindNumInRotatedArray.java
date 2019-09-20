package leetcode.array;

public class FindNumInRotatedArray {
    public static void main(String[] args) {
        int[] a ={6,7,1,2,3,4,5};
        System.out.println(minNumberRotateArray(a));

    }

    public static int minNumberRotateArray(int[] array) {
        // 日常判断
        if (array.length == 0)
            return 0;

        // 用两个指针分别指向数组的第一个元素和最后一个元素
        // 如图
        int begin = 0;
        int end = array.length - 1;
        int mid = (end - begin) / 2 + begin;
        int result = -1;

        while (begin < end) {
            if (begin == (end - 1)) {
                result = array[end];
                break;
            }
            /*
            如果中间元素大于或等于第一个指针指向的元素，那么该中间元素
            位于前面的子数组，我们把第一个指针指向该中间元素，这样缩小
            范围。In case: 56789123
             */
            else if (array[mid] >= array[begin]) {
                begin = mid;
             /*
            同理继续缩小范围。In case 6,7,1,2,3,4,5
             */
            } else if (array[mid] <= array[end]) {
                end = mid;
            }
            mid = (end - begin) / 2 + begin;
        }
        return result;
    }

}
