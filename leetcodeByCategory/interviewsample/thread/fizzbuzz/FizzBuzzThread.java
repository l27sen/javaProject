package com.scotiabank.riskmanagement.testcdoe.interviewsample.thread.fizzbuzz;

public class FizzBuzzThread extends Thread  {

    private static Object lock = new Object();
    protected static int current = 1;
    private int max;
    private boolean div3, div5;
    private String toPrint;

    public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint) {
        this.div3 = div3;
        this.div5 = div5;
        this.max = max;
        this.toPrint = toPrint;
    }

    public void print() {
        System.out.println(toPrint);
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (current > max) {
                    //return will jump outside the while(true)
                    return;
                }

                if ((current % 3 == 0) == div3 && (current % 5 == 0) == div5) {
                    print();
                    current++;
                }

//                if (current % 3 == 0 && current % 5 == 0) {
//                    System.out.println("FizzBuzz");
//                } else if (current % 3 == 0) {
//                    System.out.println("Fizz");
//                } else if (current % 5 == 0) {
//                    System.out.println("Buzz");
//                } else {
//                    System.out.println(current);
//                }
//                current++;
            }
        }
    }
}
