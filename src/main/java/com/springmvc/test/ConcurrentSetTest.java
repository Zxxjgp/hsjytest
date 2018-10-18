package com.springmvc.test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentSetTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Boolean> stringBooleanConcurrentHashMap = new ConcurrentHashMap<>();

        Set<String> names = Collections.newSetFromMap(stringBooleanConcurrentHashMap);

        names.add("Brian Goetz");
        names.add("Victor Grazi");
        names.add("Heinz Kabutz");
        names.add("Brian Goetz");

        System.out.println("names = " + names);


    }
}