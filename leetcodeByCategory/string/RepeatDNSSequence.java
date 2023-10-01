package leetcodeByCategory.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * find 10-letter-long sequences , which is repeat
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 */
public class RepeatDNSSequence {

    public List<String> find(String s){
        if(s==null ||s.length()<10){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length()-9; i++) {
            String curr = s.substring(i,i+10);
            //if already contain.
            if(!set.add(curr)){
                result.add(curr);
            }
        }
        return result;
    }

}
