package leetcodeByCategory.interviewsample.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ModifyNumInStream {

  //must use static
  static int count = 0;


  static int t = 0;

  public static void main(String[] a) {

    //使用array可以，不用final
     int[] counter = {0};

    int[] A = {1, 2, 3, 5};
    int k = 6;
    IntStream.rangeClosed(0, A.length - 1).boxed().map(x -> {
          if (!(A[t] + k >= A[x])) {
            count++;
            counter[0] =counter[0]+1;
            t = x;
          }
          return count;

        }
    ).collect(Collectors.toList());
    System.out.println(count);

  }
}
