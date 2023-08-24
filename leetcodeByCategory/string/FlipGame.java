package leetcodeByCategory.string;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {


    public static void main(String[] a){

        System.out.println(generate("++++"));
    }
    public static  List<String>  generate(String s){
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='+' && s.charAt(i-1)=='+'){
                char[] arr = s.toCharArray();
                arr[i]='-';
                arr[i-1]= '-';
                res.add(new String(arr));
            }
        }
        return res;

    }
}
