package com.jgp.test;

import org.apache.commons.fileupload.FileUploadException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class IntegerAndIntTest {
    public static  void main(String[] args){
/*        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i01==i02); //true
        System.out.println(i01==i03); //true
        System.out.println(i03==i04);   //false
        System.out.println(i02==i04);  //true*/


        String yunxingshiyichang = "RuntimeException";
        String ClassCastException = "ClasscastException";
        String ClassNotFoundException = "ClassNotFoundException";
        String IndexOutOfBoundsException = "IndexOutOdboundException";
        String ArrayIndexOutOfBoundsException = "ArrayIndexOutOfBoundException";
        String NullPointerException = "NullPointerException";
        String SQLException = "SQLException";
        String IOException = "IOException";
        String FileNotFoundException = "FileNotFoundException";
        String FileUploadException = "FileUploadException";
/*

        int num = 023;
        System.out.println(num);
        System.out.println(2 << 3);

        System.out.println( 18 & 59);
        System.out.println( 18 & 0);
*/


    /**
     * 第一种
     */

        int a = 5;
        int b = 6;
/*        a = a+b;
        b = a-b;
        a = a-b;*/

        /**
         * 第二种
         */
 /*       a = a ^ b;
        b = a ^ b;
        a = a ^ b;*/

        /**
         * 第三種
         */
    /*    a = a + b - (b = a);*/

        /**
         * 第四种
         */
         b = a+(a=b)*0;
/*
        System.out.println(a+"交换后的数据"+b);*/

/*        System.out.println(2 << 1);*/
  /*      System.out.println(matchLuhn("100332428") );
        System.out.println(matchLuhn("100331057") );
            System.out.println(matchLuhn("100329564") );
        System.out.println(matchLuhn("100327642") );
        System.out.println(matchLuhn("100333046") );*/

        String str = "6236681320002410514";
        String ss =  "6212 8361 1100 0000 069";

        System.out.println(matchLuhn(str));
        System.out.println(matchLuhn(ss));


    }

    public static boolean matchLuhn(String cardNo) {
        int[] cardNoArr = new int[cardNo.length()];
        for (int i=0; i<cardNo.length(); i++) {
            cardNoArr[i] = Integer.valueOf(String.valueOf(cardNo.charAt(i)));
        }

        for(int i=cardNoArr.length-2;i>=0;i = i - 2) {
            cardNoArr[i] <<= 1;
            cardNoArr[i] = cardNoArr[i]/10 + cardNoArr[i]%10;
        }
        int sum = 0;
        for(int i=0;i<cardNoArr.length;i++) {
            sum += cardNoArr[i];
        }
        return sum % 10 == 0;
    }

    public static char getBankCardCheckCode(String nonCheckCodeCardId){
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")||nonCheckCodeCardId.trim().length()<15
                ||nonCheckCodeCardId.trim().length()>20) {
            //如果传的数据不合法返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        // 执行luh算法
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {  //偶数位处理
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }

}
