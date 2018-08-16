package com.springmvc.xtream;

import com.springmvc.pojo.Boday;
import com.springmvc.pojo.Child;
import com.springmvc.pojo.Head;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.xtream
 * @ClassName: XtreamTest78
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/8/15 21:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/8/15 21:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class XtreamTest {
    public static void main(String[] args) {
        Child child = new Child("我是老三");
        child.setQianzi("wewqeqwewqe");
        child.setNAME("案发后");
        child.setAGE("你好啊");
        Child child1 = new Child("我是老三");

        child1.setQianzi("wewqeqwewqe");
        child1.setNAME("案发后");
        child1.setAGE("你好啊");
        List<Child> list = new ArrayList<>(16);
        list.add(child);
        list.add(child1);
        Boday b = new Boday("第二个属性");
        b.setXML_DIANHUA("8978979879");
        b.setXML_DIHZI("江苏盐城");
        b.setXML_GOUMAI("ioweiuhweirfhweui");
        b.setXML_GUIGE("eijfwiorfwehfweio");
        b.setClass("我是第二屬性");

        b.setChildren(list);


        Head head = new Head();
        head.setSHENFEN("123456");
        head.setBIANHAO("1232131223342");
        head.setSHIQU("7889789748");
        head.setGUOJIA("wewqewqeqweqw");
        head.setBodays(b);
        head.setClass("我是第一个属性");
        XStream xStream = new XStream();
        xStream.processAnnotations(Head.class);
        xStream.processAnnotations(Child.class);
        xStream.processAnnotations(Boday.class);
        String xml = xStream.toXML(head);
        System.out.println(xml);
    }
}
