package leetcodeByCategory.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

  public static void main(String[] a) {
    List strList = new ArrayList<>();

//add at last
    strList.add(0, "0");
    strList.add("2");
    strList.add("1");
    strList.sort((s1,s2)->s1.toString().compareTo(s2.toString()));

    System.out.print(strList);
  }
}
