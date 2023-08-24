package leetcodeByCategory.other;

import java.util.Arrays;

public class AppearOneNumberInArray {


  public static void main(String[] a) {
    System.out.println(Integer.toBinaryString(6));
    System.out.println("find first bit:" + findFirstBit1(6));
    System.out.println("is bit index " + isBit1(6, 0));

    int[] test = {2, 2, 3, 3, 4, 5};
    System.out.println("result:" + findNumberOnce(test)[0]+ " , "+findNumberOnce(test)[1]);

  }

  private static int findFirstBit1(int num) {
    int index = 0;
    while ((num & 1) == 0 && index < 32) {
      num >>>= 1;
      index++;
    }
    return index;
  }

  private static boolean isBit1(int num, int indexBit) {
    num = num >>> indexBit;
    return (num & 1) == 1;
  }

  public static int[] findNumberOnce(int[] data) {
    int[] result = {0, 0};
    if (data.length == 0) {
      return null;
    }

    int xorResult = 0;
    for (int i = 0; i < data.length; i++) {
      xorResult = xorResult ^ data[i];
    }

    int firstBit1Index = findFirstBit1(xorResult);

    for (int i : data) {
      if (isBit1(i, firstBit1Index)) {
        result[0] ^= i;
      } else {
        result[1] ^= i;
      }
    }

    return result;

  }


}
