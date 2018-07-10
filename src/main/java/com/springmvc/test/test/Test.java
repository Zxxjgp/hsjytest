package com.springmvc.test.test;

import com.springmvc.test.enu.Color;
import com.springmvc.test.enu.ColorE;
import com.springmvc.test.enu.Gender;
import com.springmvc.test.enu.OrderState;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author XX
 * @date
 */
public class Test {
    public static void main(String [] agrs){
        System.out.println(System.currentTimeMillis());
        Color color = Color.red;
        System.out.println(color.getClass().getName());
        System.out.println(color.name());
        System.out.println("===============================================");
        ColorE colorE = ColorE.blue;
        System.out.println(colorE.getClass().getName()+"========="+colorE.getName());
        System.out.println("===============================================");



        Gender gender = Gender.MAN;
        System.out.println(gender.getName());
        System.out.println(gender.getValue());


        System.out.println("===============================================");
        OrderState orderState = OrderState.CANCEL;
        System.out.println(orderState.getName());

        for(OrderState g : OrderState.values()) {
            System.out.println(g.getName() + "----------" + g.name() + "-----------" + g.ordinal());
        }

        for(Gender g : Gender.values()) {
            System.out.println(g.getName() + "----------" + g.name() + "**************"+g.getValue()+ "-----------" + g.ordinal());
        }

        for(Color g : Color.values()) {
            System.out.println(g + "----------" + g.name() + "**************"+g.name()+ "-----------" + g.ordinal());
        }
        System.out.println("=====================正则表达式===================");

        System.out.println(System.nanoTime());
        String regex = "\\?|\\*";
        Pattern pattern = Pattern.compile(regex);
        String patternStr = pattern.pattern();
        System.out.println(patternStr);
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());


        System.out.println(Math.random()*10);
        System.out.println(Math.nextUp(1020));

    }
}
