package leetcodeByCategory.trie;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 *
 */
class TrieNode3 {
    Map<Character, TrieNode3> children = new HashMap();
    boolean word = false;
    public TrieNode3() {}
}

/**
 * Time complexity: O(M) for the "well-defined" words
 * without dots, where M is the key length, and NNN is a number of keys,
 * and O(N⋅26M)
 * M
 *  ) for the "undefined" words
 */
public class WordDictionary {

    TrieNode3 trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode3();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode3 node = trie;

        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode3());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    /** Returns if the word is in the node. */
    public boolean searchInNode(String word, TrieNode3 node) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode3 child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                node = node.children.get(ch);
            }
        }
        return node.word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, trie);
    }
}
