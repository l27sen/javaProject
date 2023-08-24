package leetcodeByCategory.array;

/**
 * Example 1:
 *
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 */
public class ReverseString2 {


    public static void main(String[] args){

        char[] input ={'t','h',' ','d','0'};
        reverse(input);
        input.toString();
    }
    public static void reverse(char[] chars){

         rev(chars, 0, chars.length-1);

         int index =0;
         int start =0;
         while (index<= chars.length){
             if(index== chars.length||chars[index] ==' '){
                 rev(chars, 0, index-1);
                 start = index+1;
             }

             index++;
         }

    }

    public static void rev(char[] chars, int start, int end){
        while (start< end){
            char tem = chars[start];
            chars[start] = chars[end];
            chars[end] = tem;
            start++;
            end--;
        }
    }
}
