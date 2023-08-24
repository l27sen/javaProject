package leetcodeByCategory.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * TreeSet maintains objects in Sorted order defined by either
 * Comparable or Comparator method in Java
 */
public class TreeSetTest {



  public static void main(String[] a){

    Set<String> hashSet = new TreeSet<>();
    hashSet.add("ef");
    hashSet.add("ea");
    hashSet.add("eb");
    hashSet.add("ec");
    hashSet.add("a");
    hashSet.add("ec");

    hashSet.add("cd");



    for(String singleSet: hashSet){
      System.out.println(singleSet);
    }

  }
}
