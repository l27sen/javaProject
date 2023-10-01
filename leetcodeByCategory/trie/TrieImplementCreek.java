package leetcodeByCategory.trie;


import java.util.HashMap;
import java.util.Map;

class TrieNode5 {
    char c;
    HashMap <Character, TrieNode5> children = new HashMap<Character, TrieNode5>();
    boolean isLeaf;

    public TrieNode5() {}

    public TrieNode5(char c){
        this.c = c;
    }
}
//https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
public class TrieImplementCreek {

    private TrieNode5 root;

    public TrieImplementCreek() {
        root = new TrieNode5();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode5> children = root.children;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            TrieNode5 t;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode5(c);
                children.put(c, t);
            }

            children = t.children;

            //set leaf node
            if(i==word.length()-1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode5 t = searchNode(word);

        if(t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode5 searchNode(String str){
        Map<Character, TrieNode5> children = root.children;
        TrieNode5 t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }

        return t;
    }
}
