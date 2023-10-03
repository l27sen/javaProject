package leetcodeByCategory.array;

//brute force , O(n^2)
public class CounterNumOfKIndice {


    public int kBigIndices(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isKBig(arr, i, k))
                count++;
        }

        return count;
    }

    private boolean isKBig(int[] arr, int i, int k) {
        int n = arr.length;
        int count = 0;

        // scan everything to the left of i
        for (int j = 0; j < i; j++)
            if (arr[j] < arr[i])
                count++;

        if (count < k)
            return false;

        // scan everything to the right of i
        count = 0;
        for (int j = i + 1; j < n; j++)
            if (arr[j] < arr[i])
                count++;

        return count >= k;
    }
}
