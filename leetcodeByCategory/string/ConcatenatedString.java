package leetcodeByCategory.string;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 */
public class ConcatenatedString {

    public static void main(String[] args) {

        String[] ab = {"un", "iq", "ue"};
        System.out.println(get(ab));
    }

    public static int get(String[] values) {

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(values));

        int result = 0;
        while (!queue.isEmpty()) {

            String current = queue.poll();
            for (String value : values) {
                String newValue = value + current;
                if (!checkUnique(newValue)) {
                    continue;
                } else {
                    result = Math.max(result, newValue.length());
                    queue.add(newValue);
                }
            }
        }

        return result;


    }

    public static boolean checkUnique(String str) {
        HashSet<Character> char_set = new HashSet<>();

        // Inserting character of String into set
        for (int c = 0; c < str.length(); c++) {
            char_set.add(str.charAt(c));
        }

        // If length of set is equal to len of String
        // then it will have unique characters
        return char_set.size() == str.length();
    }
}
