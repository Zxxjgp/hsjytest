package com.springmvc.test.thread;
class Bank{
    private int money = 500;
    //取钱的方法，返回取钱的数目
    public synchronized int getMoney(int number){
        if(number <0){

            return -1;
        }else if (money<0) {
            return -2;
        }else if (number-money>0) {
            return -3;
        }else {
            //隔了这么久之后，成功的拿到钱
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            money-=number;
            System.out.println("卡上余额："+money);
        }

        return number;
    }

}