package company.bloomberg;

/**
 * Input: arr = [0,10,5,2]
 * Output: 1
 */
public class PeekIndexMountain {


    //mountain in the middle, so compare mid and mid+1
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] < arr[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
