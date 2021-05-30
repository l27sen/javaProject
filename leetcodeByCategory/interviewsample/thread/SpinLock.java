package com.scotiabank.riskmanagement.testcdoe.interviewsample.thread;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {


    private AtomicReference<Thread> sign = new AtomicReference<Thread>();

    public void lock(){
        Thread current=Thread.currentThread();
        //if
        while(!sign.compareAndSet(null, current)){

        }
    }

    public void unlock(){
        Thread current=Thread.currentThread();
        //set to null to unlock
        sign.compareAndSet(current, null);
    }

}
