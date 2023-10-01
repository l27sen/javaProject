package leetcodeByCategory.string;

import java.util.*;

public class WordBreak {


    public static void main(String[]a ){

        Set<String> set = new HashSet<>(Arrays.asList("cat","dog"));
        System.out.println(wordBreak("catdog", set));
    }
    public static boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    public  static boolean wordBreakHelper(String s, Set<String> dict, int start){
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

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> words = new HashSet<>(wordDict);
            Queue<Integer> queue = new LinkedList<>();
            boolean[] seen = new boolean[s.length() + 1];
            queue.add(0);

            while (!queue.isEmpty()) {
                int start = queue.remove();
                if (start == s.length()) {
                    return true;
                }

                for (int end = start + 1; end <= s.length(); end++) {
                    if (seen[end]) {
                        continue;
                    }

                    if (words.contains(s.substring(start, end))) {
                        queue.add(end);
                        seen[end] = true;
                    }
                }
            }

            return false;
        }

}
