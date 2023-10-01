package leetcodeByCategory.string;

/**
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class ReverseWordInString {


    public static void main(String[] a){
        String s = "sky blue";
        char[] result =s.toCharArray();
        reverse(result);
        System.out.println(new String(result));
    }
    public static void reverse(char[] chars){

        int i =0;

        for (int j = 0; j < chars.length; j++) {

            if(chars[j]==' '){
                reverse(chars, i, j-1);
                i=j+1;
            }

        }
        if(i< chars.length){
            reverse(chars, i, chars.length-1);

        }

        reverse(chars, 0, chars.length-1);

    }

    private static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
