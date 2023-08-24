package leetcodeByCategory.string;

public class ReverseString {

    public void reverse(char[] value){

        int left =0;
        int right = value.length-1;

        while (left< right){
            char temp = value[left];
            value[left] = value[right];
            value[right] = temp;
            left++;
            right--;
        }
    }

    //
    public void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }

    public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }

}
