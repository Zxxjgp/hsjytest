package com.springmvc.test.thread;

public class ThreadTest  extends Thread{


        private Bank bank=null;
        public ThreadTest(Bank bank) {
            this.bank=bank;
        }
        @Override
        public void run() {
           int res= bank.getMoney(400);
           if (res == -1){
               System.out.println("请输入正确的取钱数目");
           }else if (res == -2){
               System.out.println("银行卡余额不足");
           }else if (res == -3){
               System.out.println("取钱数据超过越余额不足");
           }else {
               System.out.println("取钱：" + res);
           }
        }


}
