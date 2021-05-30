package com.scotiabank.riskmanagement.testcdoe.interviewsample.thread.atm;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void draw(double drawMoney){
        reentrantLock.lock();
        try{
            if(balance>=drawMoney){
                setBalance(balance-drawMoney);
            }else {
                System.out.println("not enough");
            }
            System.out.println("current thread "+Thread.currentThread().getName());
        }
        finally {
            reentrantLock.unlock();
        }
    }
}
