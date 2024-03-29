package interviewsample.thread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CompletableFutureTest {

    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t) / 1000 + " seconds");
        return rand.nextInt(1000);
    }

    /**
     * runAsync方法也好理解，它以Runnable函数式接口类型为参数，所以CompletableFuture的计算结果为空。

     supplyAsync方法以Supplier函数式接口类型为参数,CompletableFuture的计算结果类型为U。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread name : " + Thread.currentThread().getName());
            }
        };

        CompletableFuture future1 = CompletableFuture.runAsync(runnable1);
        future1.whenComplete((v, e) -> {
            System.out.println("v1: " + v);
            System.out.println("e1: " + e);
        });

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureTest::getMoreData);
        //bicomsumer
       // BiConsumer is a functional interface; it takes two arguments and returns nothing.
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println("v: " + v);
            System.out.println("e: " + e);
        });
        System.out.println(f.get());
    }
}
