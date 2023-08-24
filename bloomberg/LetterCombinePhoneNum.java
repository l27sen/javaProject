package company.bloomberg;

import java.util.*;

/**
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 思路：外循环，iputString "23"， 内循环用queue， queue = length时，把值加一起
 */
public class LetterCombinePhoneNum {

    public static void main(String[] a){
        System.out.println(combine("23"));
    }
    public static List<String> combine(String digits){
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
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }

        return res;
    }

    //back track


    private List<String> combinations = new ArrayList<>();
    private Map <Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;

    public List<String> letterCombinations(String digits) {
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }
}
