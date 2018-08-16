package com.springmvc.xtream;

import com.springmvc.pojo.Action;
import com.springmvc.pojo.Result;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.springmvc.pojo.MVCCC;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.xtream
 * @ClassName: MVCTest
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/8/16 10:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/8/16 10:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MVCTest {
    public static void main(String[] args) {

        Result result = new Result();
        result.setName("wang博");
        result.setValue("菜鸡");

        Action action = new Action();
        action.setClassname("我是大佬");
        action.setMethod("生命的理解");
        action.setName("张三");
        action.setRlist((List) result);

        MVCCC mvccc = new MVCCC();
        mvccc.setActionlist((List) action);
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(MVCCC.class);
        xstream.toXML(mvccc);
        System.out.println(xstream.toXML(mvccc));
    }
}
