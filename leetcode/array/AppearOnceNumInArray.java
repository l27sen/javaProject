package leetcode.array;

/**
 *
 * <<      :     左移运算符，num << 1,相当于num乘以2

 >>      :     右移运算符，num >> 1,相当于num除以2

 >>>    :     无符号右移，忽略符号位，空位都以0补齐
 * 例如输入数组｛2, 4, 3, 6, 3, 2, 5 }，因为只有4 、6 这两个数字只出现一次，其他数字都出现了两次，所以输出4和6 。
 * 由于这两个数字肯定不一样，那么异或的结果肯定不为0，
 * 也就是说在这个结果数字的二进制表示中至少就有一位为1 。
 * 我们在结果数字中找到第一个为1 的位的位置，记为第n 位。
 * 现在我们以第n位是不是１为标准把原数组中的数字分成两个子数组，
 * 第一个子数组中每个数字的第n 位都是1 ， 而第二个子数组中每个数字的第n 位都是0。
 * 由于我们分组的标准是数字中的某一位是1 还是0 ，
 * 那么出现了两次的数字肯定被分配到同一个子数组。
 * 因为两个相同的数字的任意一位都是相同的，
 * 我们不可能把两个相同的数字分配到两个子数组中去，于是我们已经把原数组分成了两个子数组，每个子数组都包含一个只出现一次的数字

 */
public class AppearOnceNumInArray {

    public static int[] findNumbersAppearanceOnce(int[] data) {
        int[] result = {0, 0};

        if (data == null || data.length < 2) {
            return result;
        }

        int xor = 0;
        for (int i : data) {
            xor ^= i;
        }

        //找到第N位为1的
        int indexOf1 = findFirstBit1(xor);

        for (int i : data) {
            if (isBit1(i, indexOf1)) {
               result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }

        return result;
    }

    /**
     * 找到第N位 为1
     *
     * @param num
     * @return
     */
    private static int findFirstBit1(int num) {
        int index = 0;
        //num &&1 判断是不是1
        while ((num & 1) == 0 && index < 32) {
            //移位一个
            num >>>= 1;
            index++;
        }

        return index;
    }

    /**
     * 第N位为1
     *
     * @param num
     * @param indexBit
     * @return
     */
    private static boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int a = 2;
        System.out.println(Integer.toBinaryString(4));
        System.out.println("first bit "+findFirstBit1(4));
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result1 = findNumbersAppearanceOnce(data1);
        System.out.println(result1[0] + " " + result1[1]);

        int[] data2 = {4, 6};
        int[] result2 = findNumbersAppearanceOnce(data2);
        System.out.println(result2[0] + " " + result2[1]);

        int[] data3 = {4, 6, 1, 1, 1, 1};
        int[] result3 = findNumbersAppearanceOnce(data3);
        System.out.println(result3[0] + " " + result3[1]);
    }

}
