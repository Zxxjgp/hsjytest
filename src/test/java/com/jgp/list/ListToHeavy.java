package com.jgp.list;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class ListToHeavy {
    public static void main(String[] args){
        List<String> list = new ArrayList <>();
        list.add("秦朗");
        list.add("秦朗");
        list.add("秦朗");
        list.add("帅哥");
        list.add("美女");
        list.add("胖子");
        String [] str = {"气囊","秦朗","秦朗","秦朗"};
/*
        System.out.println(str.length);

        List<String> testlist = Arrays.asList(str);*/

      //  JSONObject jObject=new JSONObject();

/*
        System.out.println(Arrays.asList(ArrayUtils.toObject(new int[] { 1, 2 })));
        System.out.println(Arrays.asList(new Object[] { new int[] { 1, 2 } }));
        System.out.println(
                Arrays.asList(new String[] { "a", "b" }, "c"));*/
/*        System.out.println(
                Arrays.asList(new String[] { "a", "b" }));

        System.out.println(
                Arrays.asList(new Integer[] { 1, 2 }));

        System.out.println(
                Arrays.asList(new int[] { 1, 2 }));

        System.out.println(
                Arrays.asList(new String[] { "a", "b" }, "c"));*/

       /* List<String> list1 = list.stream().distinct().collect(Collectors.toList());

        System.out.println(list.size());
        System.out.println(list1.size());

        System.out.println(setlist(list).size()+"自定义1");*/
       // System.out.println(setArrayList(list).size()+"自定义删除元素");
/*        long before = System.currentTimeMillis();
        System.out.println(before);
        //System.out.println(removeDuplicate(list).size()+"自定义元素去重");

        System.out.println();
        long after = System.currentTimeMillis();
        System.out.println(after);
        System.out.println(after-before);*/
    }
    //元素去重
    public static List setlist(List list){
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }
    //删除元素
    public static  List setArrayList(List list){
        ArrayList<String> lists= new ArrayList<>();
        Iterator<String> iterator= list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str == "美女") {
                iterator.remove();
            }
        }
        return list;
    }

    //元素的去重
    public static List removeDuplicate(List list){
        List listTemp = new ArrayList();
        for(int i=0;i<list.size();i++){
            if(!listTemp.contains(list.get(i))){
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }
    // 删除ArrayList中重复元素，保持顺序
    public static void removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        System.out.println( " remove duplicate " + list);
    }
}
