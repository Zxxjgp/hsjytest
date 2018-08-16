package com.springmvc.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.pojo
 * @ClassName: Boday
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/8/15 21:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/8/15 21:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Boday {
    private String XML_GOUMAI;
    private String XML_DIHZI;
    private String XML_DIANHUA;
    private String XML_GUIGE;
    @XStreamAsAttribute
    @XStreamAlias("class")
    private String Class ;


    public Boday(String aClass) {
        Class = aClass;
    }

    public void setClass(String Class) {
        Class = Class;
    }


    @XStreamImplicit(itemFieldName="ChildV")//这句话是关键
    private List<Child> childrev;

    public String getXML_GOUMAI() {
        return XML_GOUMAI;
    }

    public void setXML_GOUMAI(String XML_GOUMAI) {
        this.XML_GOUMAI = XML_GOUMAI;
    }

    public String getXML_DIHZI() {
        return XML_DIHZI;
    }

    public void setXML_DIHZI(String XML_DIHZI) {
        this.XML_DIHZI = XML_DIHZI;
    }

    public String getXML_DIANHUA() {
        return XML_DIANHUA;
    }

    public void setXML_DIANHUA(String XML_DIANHUA) {
        this.XML_DIANHUA = XML_DIANHUA;
    }

    public String getXML_GUIGE() {
        return XML_GUIGE;
    }

    public void setXML_GUIGE(String XML_GUIGE) {
        this.XML_GUIGE = XML_GUIGE;
    }

    public List<Child> getChildren() {
        return childrev;
    }

    public void setChildren(List<Child> childrev) {
        this.childrev = childrev;
    }


    public List<Child> getChildrev() {
        return childrev;
    }

    public void setChildrev(List<Child> childrev) {
        this.childrev = childrev;
    }


}
