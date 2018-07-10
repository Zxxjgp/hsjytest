package com.jgp.one;

import java.util.Arrays;
import java.util.List;

public class MondayTest {
    public  static  void main(String[] args){
        /************************************************************************************************/
/*        System.out.println("江苏华生基因数据科技股份有限公司");
        System.out.println("江苏华生基因数据科技股份有限公司,注册资金7440万元股票名称：华生基因,股票代码：833190");
        Integer[] a ={33,34,43,12};
        Integer[] f =null;
        List list = Arrays.asList(a);
        System.out.println(list);*/

        /************************************************************************************************/
/*        MondayTest mondayTest = new MondayTest();
        mondayTest.bubbleSort(a);
        List lists = Arrays.asList(a);
        System.out.println(lists);


        mondayTest.selectSort(a);
        List listss = Arrays.asList(a);
        System.out.println(listss);*/

        System.out.println(100%3);
        System.out.println(100%3.0);
    }
    public   void bubbleSort(Integer[] a){
        int len=a.length;

        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){//注意第二重循环的条件
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

    public  void sort(Integer[] a){
        int leng = a.length;
        for (int i = 0; i< leng ; i++){
            int value = a[i];
            int position = i;
            for (int j = i+1 ; i < leng ; i++){
                if (a[j] < value){
                    value = a[j];
                    position = j;
                }
                a[position] = a[i];
                a[i] = value;
            }
        }
    }
    public void selectSort(Integer[]a){
        int len=a.length;
        for(int i=0;i<len;i++){//循环次数
            int value=a[i];
            int position=i;
            for(int j=i+1;j<len;j++){//找到最小的值和位置
                if(a[j]<value){
                    value=a[j];
                    position=j;
                }
            }
            a[position]=a[i];//进行交换
            a[i]=value;
        }
    }
}
