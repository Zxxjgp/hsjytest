package com.springmvc.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("mvc")
public   //如果不写这个，你试试看是怎样的效果呢？
class MVCCC {
    @XStreamImplicit() //这个你可以删除试试
    @XStreamAlias("action")
    private List actionlist;
    public List getActionlist() {
    return actionlist;
    }


    public void setActionlist(List actionlist) {
    this.actionlist = actionlist;
    }
}
