package leetcodeByCategory.string;

import java.util.List;
import java.util.Set;

//https://www.youtube.com/watch?v=-lIPQo1jFpg&ab_channel=happygirlzt

/**
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 */
public class WordBreak2 {

    Set<String> wordset;

    //s is input value
    private void dfs(String s, int index, List<String> res, StringBuilder curr){
        int n = s.length();
        if(n == index){
            res.add(curr.toString());
        }
        for (int i = index; i < n; i++) {
            if(wordset.contains(s.substring(index,i+1))){
                int beforeadding = curr.length();
                if(beforeadding ==0){
                    curr.append(s.substring(index, i+1));
                }else{
                    curr.append(" ");
                    curr.append(s.substring(index, i+1));

                }

                //get from next
                dfs(s, index+1, res, curr);
                curr.delete(beforeadding, curr.length());
            }

        }
    }
}
