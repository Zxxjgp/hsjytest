package com.utils.collectors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: hsjytest
 * @Package: com.utils.collectors
 * @ClassName: CollectorsTest
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/7/24 16:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/7/24 16:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CollectorsTest {
    public static void main(String[] args) {
        Collectors.toList();
    }
    @Test
    public void getdaba(){
        List<String> list = new ArrayList<>();
        list.add("秦朗");
        list.add("秦朗");
        list.add("秦朗");
        list.add("帅哥");
        list.add("美女");
        list.add("胖子");
        list = list.stream().distinct().collect(Collectors.toList());
        String cloectors = list.iterator().next();
        System.out.println(cloectors.toString());
        System.out.println(list.size());
    }
}
