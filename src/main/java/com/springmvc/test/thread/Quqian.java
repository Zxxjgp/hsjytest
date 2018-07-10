package com.springmvc.test.thread;

public class Quqian extends Thread {
    Bank bank= new Bank();
    @Override
    public void run() {
        System.out.println("执行顺序"+bank.getMoney(400));
    }


}
