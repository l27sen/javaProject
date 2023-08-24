package leetcodeByCategory.string;

/**
 * Input:
 s = "AABABBA", k = 1

 Output:
 4
 Explanation:
 Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingChar {

    // method to find the maximum length of
    // substring having character ch
    static int findLen(String A, int length, int limit, char ch)
    {
        int maxlen = 1;
        int cnt = 0;
        int l = 0, r = 0;

        // traverse the whole string
        //一直增加 R ++，直到counter > limit
        while (r < length) {

            /* if character is not same as ch
               increase count */
            if (A.charAt(r) != ch)
                ++cnt;

            /* While  count > k  traverse the string
               again until count becomes less than k
               and decrease the count when characters
               are not same */
            //counter是因为不重复的加的，所以减少的时候也是需要不重复的减少
            while (cnt > limit) {
                if (A.charAt(l) != ch)
                    --cnt;
                ++l;
            }

            /* length of substring will be rightIndex -
               leftIndex + 1. Compare this with the maximum
               length and return maximum length */
            maxlen = Math.max(maxlen, r - l + 1);
            ++r;
        }
        return maxlen;
    }

    //leetcode
    //思路用 feq 存是否重复的数量，然后比较 两个指针的距离 +K
    public static int getValue(String s, int k){

        int left =0; int right = 0;
        int[] feq = new int[26];
        char[] ch = s.toCharArray();
        int max = 0;
        while (right< ch.length){
            feq[ch[right]-'A']++;
            max = Math.max(max, feq[ch[right]-'A']);
            right++;
            //重点： if the gap is bigger than the 出现次数+k，那么移动指针
            if (right - left > max + k) {
                //left move
                feq[ch[left]-'A']--;
                left++;
            }

        }

    return right-left;
    }

    // method which returns maximum length of substring
    static int answer(String A, int n, int k)
    {
        int maxlen = 1;
        for (int i = 0; i < 26; ++i) {
            maxlen = Math.max(maxlen, findLen(A, n, k, (char) (i+'A')));
            maxlen = Math.max(maxlen, findLen(A, n, k, (char) (i+'a')));
        }
        return maxlen;
    }

    // Driver Method
    public static void main(String[] args)
    {
        int n = 5, k = 2;
        String A = "ABCABA";
        System.out.println("Maximum length = " + getValue(A,  k));

        n = 6; k = 4;
        String B = "HHHHHH";
        System.out.println("Maximum length = " + answer(B, n, k));


    }
}
