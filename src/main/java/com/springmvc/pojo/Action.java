package com.springmvc.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("action")
public class Action {

        @XStreamAsAttribute()
        @XStreamAlias("name")
        private String name;
        @XStreamAsAttribute()
        @XStreamAlias("class")
        private String classname;
        @XStreamAsAttribute()
        @XStreamAlias("method")
        private String method;
        @XStreamImplicit
        @XStreamAlias("result")
        private List rlist;


        public String getName() {
        return name;
        }


        public void setName(String name) {
        this.name = name;
        }


        public String getClassname() {
        return classname;
        }


        public void setClassname(String classname) {
        this.classname = classname;
        }


        public String getMethod() {
        return method;
        }
        public void setMethod(String method) {
        this.method = method;
        }


        public List getRlist() {
        return rlist;
        }


        public void setRlist(List rlist) {
        this.rlist = rlist;
        }
}