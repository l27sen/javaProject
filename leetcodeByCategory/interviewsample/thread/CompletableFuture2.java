package leetcodeByCategory.interviewsample.thread;
import java.util.concurrent.CompletableFuture;

//https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650

/**
 * 异步任务结束时，会自动回调某个对象的方法；
 * 异步任务出错时，会自动回调某个对象的方法；
 * 主线程设置好回调后，不再关心异步任务的执行。
 */
public class CompletableFuture2 {
  public static void main(String[] args) throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFuture2::fetchPrice);
    // 如果执行成功:
    cf.thenAccept((result) -> {
      System.out.println("price: " + result);
    });
    // 如果执行异常:
    cf.exceptionally((e) -> {
      e.printStackTrace();
      return null;
    });
    System.out.println("from main thread");
    // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
    Thread.sleep(200);
  }

  static Double fetchPrice() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
    }
    if (Math.random() < 0.3) {
      throw new RuntimeException("fetch price failed!");
    }
    return 5 + Math.random() * 20;
  }
}
