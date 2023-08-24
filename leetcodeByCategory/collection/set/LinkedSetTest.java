package leetcodeByCategory.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedSetTest {


  /**
   * LinkedHashSet maintains the insertion order. When we iterate through a HashSet,
   * the order is unpredictable while it is predictable in case of LinkedHashSet
   * @param a
   */
  public static void main(String[] a){

    Set<Integer> hashSet = new LinkedHashSet<>();
    hashSet.add(1);
    hashSet.add(3);
    hashSet.add(2);
    hashSet.add(0);


    for(Integer singleSet: hashSet){
      System.out.println(singleSet.intValue());
    }

  }
}
