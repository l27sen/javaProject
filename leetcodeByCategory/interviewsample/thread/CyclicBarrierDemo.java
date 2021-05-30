package com.scotiabank.riskmanagement.testcdoe.interviewsample.thread;

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
                //only all thread come to await, then they go togehter to after code
                  cyclicBarrier.await();

              }catch (Exception e){

              }
            },String.valueOf(i)).start();
        }
    }
}
