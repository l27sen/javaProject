package com.scotiabank.riskmanagement.testcdoe.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {



  public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>();
    ints.add(3); ints.add(5); ints.add(10);
    double sum = sum(ints);
    System.out.println("Sum of ints="+sum);

    List<Long> longs = new ArrayList<>();
    longs.add(3L); longs.add(5L); longs.add(10L);
    double sum2 = sum(ints);
    System.out.println("Sum of longs="+sum2);
  }

  public static double sum(List<? extends Number> list){
    double sum = 0;
    for(Number n : list){
      sum += n.doubleValue();
    }
    return sum;
  }

}
