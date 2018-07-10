package com;

public interface TestDao {
    default void print(){
        System.out.println("hello word");

    }
}
