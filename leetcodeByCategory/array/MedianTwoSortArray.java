package leetcodeByCategory.array;


/**
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Time complexity: O(m+n)
 *
 *
 */
public class MedianTwoSortArray {

    private int p1 = 0, p2 = 0;

    // Get the smaller value between nums1[p1] and nums2[p2] and move the pointer forwards.


    public static void main(String[] a){
        int[] num1 = {1,2};
        int[] num2 = {3,5};

        MedianTwoSortArray medianTwoSortArray = new MedianTwoSortArray();
        System.out.println(medianTwoSortArray.findMedianSortedArrays2(num1,num2));
    }
    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            //If p2 is outside nums2, just move p1 one place to the right.
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            //If p1 is outside nums1, just move p2 one place to the right.
            return nums2[p2++];
        }
        return -1;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return (double)(getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < (m + n) / 2; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }


    //easy understand
    //https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2987826/simple-java-beats-100-easy-to-understand/
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int n1 = nums1.length;          // find the length of both arrays.
        int n2 = nums2.length;

        int n = n1+n2;                  // length of new array.

//      create a new array to store all the elements.
        int [] res = new int[n];

        int i = 0;                      // i will point to num1.
        int j = 0;                      // j will point to num2.
        int k = 0;                      // k will point to res.

        while(i < n1 && j < n2)         // while num1 and num2 has elements.
        {
            if(nums1[i] <= nums2[j])    // if element is num1 is smaller than num2
            {
//              smaller element goes into new array and
//              ONLY the index of that element is incremented.
                res[k] = nums1[i++];
            }
            else
            {
                res[k] = nums2[j++];
            }
            // finally, k is incremented. It is outside of if-else because it will be
            // incremented in both the cases.
            k++;
        }
        while(i < n1)                   // it means nums2 has ended. So, add all elements of
        {                               // nums1 in res.
            res[k++] = nums1[i++];
        }
        while(j < n2)                   // it means nums1 has ended. So, add all elements of
        {                               // num2 in res.
            res[k++] = nums2[j++];
        }



        double median;          // declaring median;
        n--;                    // n represents the last index.
        if(n % 2 != 0)          // if the total elements are odd.
        {
            median = (double) (res[n/2] + res[(n/2) + 1])/2;
        }
        else                    // if the total elements are even
        {
            median = res[n/2];
        }

//      finally, return the median.
        return median;

    }
}

