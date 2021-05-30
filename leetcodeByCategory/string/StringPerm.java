package com.scotiabank.riskmanagement.testcdoe.string;

public class StringPerm {

  public static void main(String a[]) {
    perm("", "ab");
  }

  public static void perm(String prefix, String end) {
    int n = end.length();
    if (n == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        perm(prefix + end.charAt(i), end.substring(0, i) + end.substring(i + 1, n));
      }
    }
  }
}
