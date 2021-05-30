package com.scotiabank.riskmanagement.testcdoe.generic;

import java.util.ArrayList;
import java.util.List;

public class UnBound {
  public static void printData(List<?> list){
    for(Object obj : list){
      System.out.println(obj + "::");
    }
  }

  //We can provide List<String> or List<Integer> or
  // any other type of Object list argument to the printData method
  public static void main(String[] a){
    List<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    List<String> stringArrayList = new ArrayList<>();
    stringArrayList.add("abc");
    printData(integerList);
    printData(stringArrayList);

    //// OK. List<? extends Integer> is a subtype of List<? extends Number>
    List<? extends Integer> intList = new ArrayList<>();
    List<? extends Number>  numList = intList;
    Integer aa = 1;

  }
}
