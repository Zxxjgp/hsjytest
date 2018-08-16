package com.springmvc.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.pojo
 * @ClassName: Child
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/8/15 21:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/8/15 21:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@XStreamAlias("Child")
public class Child {

    private String NAME;
    private String AGE;
    private String qianzi;
    @XStreamAsAttribute
    @XStreamAlias("class")
    private  String Class;

    public Child(String Class) {
        this.Class = Class;
    }


    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getAGE() {
        return AGE;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }

    public String getQianzi() {
        return qianzi;
    }

    public void setQianzi(String qianzi) {
        this.qianzi = qianzi;
    }

    @Override
    public String toString() {
        return "Child{" +
                "NAME='" + NAME + '\'' +
                ", AGE='" + AGE + '\'' +
                ", qianzi='" + qianzi + '\'' +
                ", Class='" + Class + '\'' +
                '}';
    }
}
