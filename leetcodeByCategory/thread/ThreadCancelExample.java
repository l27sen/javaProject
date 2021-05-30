package com.scotiabank.riskmanagement.testcdoe.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadCancelExample {

  public void test() {

    ExecutorService executorService = Executors.newFixedThreadPool(3);
    MyCallable task = new MyCallable();
    Future future = executorService.submit(task);
    try {
      future.get(3, TimeUnit.MILLISECONDS);

    } catch (Exception ex) {
      ex.printStackTrace();
      //stop a thread
      future.cancel(true);
    }

  }

//   class Task implements Runnable{
//    public void run(){
//    }

  class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
      System.out.println("...");
      Thread.sleep(5000);
      return "OK";
    }
  }


}
