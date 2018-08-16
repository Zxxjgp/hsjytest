package com.springmvc.test;

import org.apache.xpath.operations.Bool;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class CollectionsDemo {
   public static void main(String args[]) {
      // create map
      Map<String, Boolean> map = new WeakHashMap<String, Boolean>();


      // create a set from map
      Set<String> set = Collections.newSetFromMap(map);

      // add values in set
      set.add("Java");
      set.add("C");
      set.add("C++");

      // set and map values are
      System.out.println("Set is: " + set);
      System.out.println("Map is: " + map);
      System.out.println(map.get("C++"));

   }
}