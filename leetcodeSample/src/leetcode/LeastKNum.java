package leetcode;
//https://my.oschina.net/7001/blog/1633536

/**
 *将数组分成两部分Sa和Sb，其中Sa的元素>=key，Sb的元素<key，然后分析两种情况：

 若Sa中元素的个数大于或等于k，则在Sa中查找最大的k个数
 若Sa中元素的个数小于k，其个数为len，则在Sb中查找k-len个数字
 如此递归下去，不断把问题分解为更小的问题，直到求出结果。
 该算法的平均时间复杂度为O(N * logk)。以求K大的数为例，算法实现如下：


 */
public class LeastKNum {

    public static void getLeastNumbers(int[] input, int[] output) {

        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        int target = output.length - 1;

        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);

//            int pivot = input[(start + end) / 2];
//            index = partitionTest(input, start, end, pivot);
        }

        System.arraycopy(input, 0, output, 0, output.length);
    }

    /**
     * 分区算法
     *
     * @param input 输入数组
     * @param start 开始下标
     * @param end   结束下标
     * @return 分区位置  分区的左边 比轴值小，右边大, 如果这个值等于 K ，那么前面左边的就是least K
     */
    private static int partition(int[] input, int start, int end) {
        //partition value in each round
        int tmp = input[start];
        while (start < end) {
            //find right value smaller than partition value
            while (start < end && input[end] >= tmp) {
                end--;
            }
            // 把右边的值交换到左边
            input[start] = input[end];
            //find value bigger than tmp.
            while (start < end && input[start] <= tmp) {
                start++;
            }
            //左边的值交换到右边
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }



    private static int partitionTest(int[] array, int left, int right, int pivot) {

        //pay attention, here is <=
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }

        }
        return left;
    }




    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        test1();
    }


    private static void test1() {
        int[] data = {5, 1, 4, 6, 2, 7, 3, 8};

        int[] output = new int[3];
        getLeastNumbers(data, output);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] output2 = new int[8];
        getLeastNumbers(data, output2);
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();


    }


}
