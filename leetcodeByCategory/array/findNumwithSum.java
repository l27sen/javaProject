package leetcodeByCategory.array;

import java.util.ArrayList;
import java.util.List;

/**
 * ｛1 、2 、4、7 、11 、15 ｝和数字15. 由于4+ 11 = 15
 * 方法类似二分查找
 */
public class findNumwithSum {

    public static void main(String[] args){
        int[] inputs = {1 ,2 ,4,7,11 ,15};
        List<Integer> results = findNumbersWithSum(inputs, 15);
        results.size();
    }
    /*
     array is sorted
     */
    public static List<Integer> findNumbersWithSum(int[] data, int sum) {

        int start = 0;
        int end = data.length - 1;

        List<Integer> result = new ArrayList<>();
        while (start < end) {
            if (data[start] + data[end] == sum) {
                result.add(data[start]);
                result.add(data[end]);
                break;
            } else if (data[start] + data[end] < sum) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}
