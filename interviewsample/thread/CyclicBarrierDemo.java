package interviewsample.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String args[]){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("finish thread");
        });

         for (int i = 0; i <3 ; i++) {
            final int temp = i;
            new Thread(()->{
              System.out.println("start "+temp);
              try {
                  cyclicBarrier.await();

              }catch (Exception e){

              }
            },String.valueOf(i)).start();
        }
    }
}
