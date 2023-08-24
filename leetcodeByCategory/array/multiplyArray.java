package leetcodeByCategory.array;

/**
 * https://blog.csdn.net/zl18310999566/article/details/80271566
 *
 * B[0]=A[1]×A[2]=2×3=6
 B[1]=A[0]×A[2]=1×3=3
 B[2]=A[0]×A[1]=1×2=2
 */
public class multiplyArray {


    public static int[] multiply2(int[] array) {
        if (array == null) {
            return null;
        }
        int len = array.length;
        if (len == 0) {
            return null;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        int[] result = new int[len];
        // 数组B中第一个数字没有左边部分，所以左边乘积数组第一个数字是1
        left[0] = 1;
        // 计算B[i]对应的在A中的左边部分的乘积，数组A从前向后计算
        for (int i = 1; i < len; i++) {
            // 因为要B[i]不需要计算A[i]，所以左边部分的乘积计算其实需要的是A中对应下标i的上一个下标及之前的数字
            left[i] = left[i - 1] * array[i - 1];
        }
        // 数组B中最后一个数字没有右边部分，所以右边乘积数组的最后一个数字是1
        right[len - 1] = 1;
        // 计算B[i]对应的在A中的右边部分的乘积，数组A从后向前计算，这样才可以一次遍历完
        // 因为计算可以用到上一次的结果，即上一次的结果*本次下标的值
        for (int i = len - 1; i > 0; i--) {
            // 因为要B[i]不需要计算A[i]，所以右边部分的乘积计算其实需要的是A中对应下标i的下一个下标及之后的数字
            right[i - 1] = right[i] * array[i];
        }
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;

    }

    //暴力法 o (n*n)
    public static int[] multiply3(int[] number) {
        if (number == null) {
            return null;
        }
        int len = number.length;
        if (len == 0) {
            return null;
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int multiply = 1;
            for (int j = 0; j < len; j++) {
                //对角线不要
                if (j != i) {
                    multiply *= number[j];
                }
            }
            result[i] = multiply;
        }
        return result;
    }



}
