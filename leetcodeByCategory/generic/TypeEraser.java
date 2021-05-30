package com.scotiabank.riskmanagement.testcdoe.generic;

import java.util.ArrayList;
import java.util.List;

public class TypeEraser {

  public static void main(String[] a){
    List<String> l1 = new ArrayList<String>();
    List<Integer> l2 = new ArrayList<Integer>();

    System.out.println(l1.getClass() == l2.getClass());

  }
}
