package leetcodeByCategory.jacob;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinePhoneNum {

    public List<String> combine(String digits){
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        String[] dict = {"","","abc","def","ghi"};

        for (int i = 0; i < digits.length() ; i++) {
            int num = digits.charAt(i)-'0';
            String str = dict[num];
            //when length is the digits length, it will store
            while (queue.peek().length()==i){
                String curr= queue.poll();

                for(char c: str.toCharArray()){
                    queue.offer(curr+String.valueOf(c));
                }
            }
        }

        List<String> res = new ArrayList<>();
        while (queue.isEmpty()){
            res.add(queue.poll());
        }

        return res;
    }
}
