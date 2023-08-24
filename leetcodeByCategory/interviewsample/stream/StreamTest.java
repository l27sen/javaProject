package leetcodeByCategory.interviewsample.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

  public static void main(String[] a){

    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");


    System.out.println("初始时："+ list.toString());
    list.removeIf(s -> s.contains("1"));
    System.out.println("过滤完：" + list.toString());
  }
}
