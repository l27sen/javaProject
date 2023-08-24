package leetcodeByCategory.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Set is a collection that cannot contain duplicate elements
 * Set interface doesn’t allow random-access to an element in the Collection.
 * You can use iterator or foreach loop to traverse the elements of a Set
 */
public class HashSetTest {


  public static void main(String[] a){

    Set<Integer> hashSet = new HashSet<>();
    hashSet.add(3);
    hashSet.add(1);
    hashSet.add(2);

//    看到有序的结果也是正常的，但不能依赖这个有序行为。
//    况且HashSet并不关心key的“排序
    for(Integer singleSet: hashSet){
      System.out.println(singleSet.intValue());
    }

  }
}
