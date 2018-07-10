package com.springmvc.test.thread;

class Xc implements Runnable{
      
public int chepiao = 100;  
    @Override
    public void run(){
        while (true) {  
            if(chepiao>0){  
                System.out.println("第" + Thread.currentThread().getName() + "个车站正在卖出第" + (101-chepiao) + "张车票");  
                --chepiao;  
            }else{  
                break;  
            }  
        }  
    }  
} 