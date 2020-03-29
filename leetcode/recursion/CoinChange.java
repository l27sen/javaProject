package leetcode.recursion;

import java.util.HashMap;
import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {

        System.out.println(combo(4));
//        System.out.println(numWaysWithNoCache(5, coins,0));
    }

    public static long numWays(int n, int[] coins) {
        if (n < 0) {
            return 0;
        }
        return numWays(n, coins, 0, new HashMap<String, Long>());
    }

    public static long numWays(int n, int[] coins, int coinNumber, HashMap<String, Long> cache) {
        /* Check our cache */
        String key = n + "," + coinNumber;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        /* Base case */
        if (coinNumber == coins.length - 1) {
            if (n % coins[coinNumber] == 0) {
                cache.put(key, 1L);
                return 1;
            } else {
                cache.put(key, 0L);
                return 0;
            }
        }
        /* Recursive case */
        long ways = 0;
        for (int i = 0; i <= n; i += coins[coinNumber]) {
            ways += numWays(n - i, coins, coinNumber + 1, cache);
        }
        /* Cache and return solution */
        cache.put(key, ways);
        return ways;
    }

    public static int[] coinArray = {4, 1};

    public static long combo(int amount) {

        if (amount == 0) {
            System.out.println(" remain:" + amount + " found way +1");
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        int ways = 0;
        //使用循环加recursive就可以遍历所有种类
        for (int count = 0; count < coinArray.length; count++) {
            //try every amount with different coin type
            System.out.println("amount " + amount + " coin " + coinArray[count]);
            ways += combo(amount - coinArray[count]);
        }
        return ways;
    }
}

