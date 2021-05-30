package com.scotiabank.riskmanagement.testcdoe.map;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
  public static void main(String[] args) {
    ConcurrentHashMap map = new ConcurrentHashMap();
    Object b = map.put("d","c");
    System.out.println(b);

    Object a =map.putIfAbsent("d","a");
    System.out.println(a);
  }
}
