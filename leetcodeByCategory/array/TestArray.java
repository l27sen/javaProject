package leetcodeByCategory.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestArray {

    public static void main(String[] a) {
        int[] aa = {1, 2, 3};
        System.out.println(solution(aa));
    }

    public static int solution(int[] A) {
        // Implement your solution here


        Set<Integer> values = new HashSet<>();
        for (int i = 1; i <= A.length; i++) {
            values.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            values.remove(A[i]);
        }

        if (values.isEmpty()) {
            return A.length + 1;
        } else {
            int min = Integer.MAX_VALUE;
            for (Integer vale : values) {
                if (vale < min) {
                    min = vale;
                }
            }
            return min;
        }

    }
}
