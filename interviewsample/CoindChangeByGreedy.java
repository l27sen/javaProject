package interviewsample;

import java.util.ArrayList;
import java.util.List;

public class CoindChangeByGreedy {

    static int[] coin = {1, 2, 5, 10};

    public static void findCombineArray(int amount) {
        List<Integer> result = new ArrayList<>();

        for (int i = coin.length - 1; i >= 0; i--) {
            while (amount >= coin[i]) {
                amount = amount - coin[i];
                result.add(coin[i]);
            }
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        int n = 26;
        //should be 10,10,5,1
        findCombineArray(n);

    }
}
