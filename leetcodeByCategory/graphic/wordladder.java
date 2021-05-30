package com.scotiabank.riskmanagement.testcdoe.graphic;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 */
class WordNode {
    String word;
    int numSteps;

    public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}

public class wordladder {

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> wordDict = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
        wordladder wordladder1 = new wordladder();
        System.out.println("result length "+wordladder1.ladderLength(start,end,wordDict));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));

        wordDict.add(endWord);

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            if (word.equals(endWord)) {
                return top.numSteps;
            }

			//current word.
            char[] arr = word.toCharArray();
			//replace every 'char' in the word
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (wordDict.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1));
                        wordDict.remove(newWord);
                    }

                    arr[i] = temp;
                }
            }
        }

        return 0;
    }
}
