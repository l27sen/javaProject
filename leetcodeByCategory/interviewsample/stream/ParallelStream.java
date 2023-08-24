package leetcodeByCategory.interviewsample.stream;

import java.util.stream.IntStream;

public class ParallelStream {
  public static void main(String[] a) {

    IntStream range2 = IntStream.rangeClosed(1, 10);
//    range2.parallel().forEach(System.out::println);

    range2.parallel().forEach(x -> {
      System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
    });
  }
}
