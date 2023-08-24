package leetcodeByCategory.jacob;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generate(int n) {
        List<String> res = new ArrayList<>();

        return res;
    }

    public void helper(String curr, int left, int right, List<String> res) {
        if (left == right && left == 0) {
            res.add(curr);
            return;
        }

        if (left > 0) {
           helper(curr+"(", left-1, right, res);
        }

        if (right > left) {
            helper(curr+")", left, right-1, res);
        }
    }

}
