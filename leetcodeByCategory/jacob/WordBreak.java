package leetcodeByCategory.jacob;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

    public boolean canBreak(String s, List<String> dict) {

       boolean[] dp = new boolean[s.length()+1];
       
       dp[0]=true;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j < i ; j++) {
                if(dp[j] && dict.contains(s.substring(j,i))){

                    dp[i]=true;
                    break;
                }

            }
        }

        return dp[s.length()];
    }

    //native method

    public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length())
            return true;

        for(String a: dict){
            int len = a.length();
            int end = start+len;

            //end index should be <= string length
            if(end > s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }

        return false;
    }

    Map<String, Boolean> map;
    boolean helper(String s, Set<String> dist) {
        if(s.length()==0) {
            //store the ans
            map.put(s,true);
            return true;
        }
        if(map.containsKey(s)) return map.get(s);
        //Rather than going char by char, we can go word by word
        for(String w: dist) {
            if(s.startsWith(w)) {
                String sub = s.substring(w.length());
                if(helper(sub,dist)){
                    //store the answer for future use
                    map.put(sub,true);
                    return true;
                }
            }
        }
        //store the answer
        map.put(s,false);
        return false;
    }
}
