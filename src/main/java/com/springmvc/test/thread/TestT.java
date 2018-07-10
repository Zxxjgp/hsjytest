package com.springmvc.test.thread;

public class TestT {


    public static  void main(String [] args){

/*        Bank b = new Bank();
        ThreadTest bt1= new ThreadTest(b);
        bt1.start();
        ThreadTest bt= new ThreadTest(b);
         bt.start();*/
/*        Thread1 mTh1=new Thread1("A");
        Thread1 mTh2=new Thread1("B");
        mTh1.start();
        mTh2.start();*/
        Thread c = new Thread(new Xc());
        c.start();
        Thread c1 = new Thread(new Xc());
        c1.start();
    }
}
