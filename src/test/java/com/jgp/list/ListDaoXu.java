package com.jgp.list;

import java.util.*;

public class ListDaoXu {
    public static void main(String[] args) {
        List <String> list = new ArrayList <>();
        list.add("秦朗");
        list.add("秦朗");
        list.add("秦朗");
        list.add("帅哥");
        list.add("美女");
        list.add("胖子");
        Collections.reverse(list);
        for (String string: list) {
            System.out.println(string);
        }
        sethash(list);
        dele(list);
    }

    public static  void sethash(List list){
        HashSet set = new HashSet(list);
        set.hashCode();
        System.out.println(set.getClass());
        Set k = new HashSet(list);
        System.out.println(k.getClass());
        list.clear();
        list.addAll(set);
        System.out.println(list.size());
        for (Object string: list) {
            System.out.println(string.toString());
        }
    }
    /**
     * 删除特定的元素
     */
    public static  void dele(List list){
        Iterator<String> iterator = list.iterator();
        if (iterator.hasNext()){
            String g = iterator.next();
            if ( "胖子".equals(g)){
                System.out.println("胖子" == g);
                iterator.remove();
                System.out.println(list.size());
            }
        }
    }
}
