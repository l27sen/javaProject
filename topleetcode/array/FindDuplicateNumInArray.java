package topleetcode.array;

import java.util.Arrays;

/**
 * 如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * don't use hash, 0(n), try space is o(1)
 * if a[i]和第m个数字不相等，就把第i个数字和第m个数字交换，
 * 把m放到属于它的位置。接下来再重读这个比较、交换的过程，直到我们发现一个重复的数字
 */
public class FindDuplicateNumInArray {

    //数组中的数字都在0到n-1
    public static int findDup(int[] array) {

        // 判断输入的是否在[0, number.length-1]之间
        for (int i : array) {
            if (i < 0 || i >= array.length) {
                return -1;
            }
        }


        for (int i = 0; i < array.length; i++) {
            //swap until a[i]= i,
            while (array[i] != i) {
                // array[i]位置的数字相同，说明有重复数字
                if (array[i] == array[array[i]]) {
                    return array[i];
                } else {
                    swap(array, i, array[i]);
                }
            }
        }
        return -1;
    }

    private static void swap(int[] data, int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(findDup(numbers1));
        System.out.println("findDuplicate:"+findDuplicate(numbers1));

    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }
}
