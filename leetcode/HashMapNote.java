package leetcode;

import java.util.HashMap;

/**
 * magzine is : two times three is not four
  note is:  two times two is four, then "no", because, note has 2 "two"
 */
public class HashMapNote {

    public static void main(String[] args) {
        String[] magazine ={"test","bb"};
        String[] note = {"test","test"} ;
         canCreate(magazine,note);

    }

    private static HashMap<String, Integer> makeMap(String [] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.merge(words[i], 1, Integer::sum);
        }
        return map;
    }



    public static void canCreate(String [] magazine, String [] ransom) {
        HashMap<String, Integer> usableWords = makeMap(magazine);
        for (int i = 0; i < ransom.length; i++) {
           if(usableWords.containsKey(ransom[i])&& usableWords.get(ransom[i])>0){
               Integer currentValue = usableWords.get(ransom[i]);
               usableWords.put(ransom[i],currentValue-1);
           }else{
               System.out.println("NO");
               return;
           }
        }
        System.out.println("Yes");
    }
}
