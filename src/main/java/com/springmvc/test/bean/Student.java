package com.springmvc.test.bean;

import javax.print.DocFlavor;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.test.bean
 * @ClassName: Student
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/7/26 16:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/7/26 16:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Student {
    private String name ;
    private String factior;
    private String girlFriends;

    public Student(String name, String factior, String girlFriends) {
        this.name = name;
        this.factior = factior;
        this.girlFriends = girlFriends;
    }

    public Student(String factior) {
        this.factior = factior;
    }
    public Student() {
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactior() {
        return factior;
    }

    public void setFactior(String factior) {
        this.factior = factior;
    }

    public String getGirlFriends() {
        return girlFriends;
    }

    public void setGirlFriends(String girlFriends) {
        this.girlFriends = girlFriends;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", factior='" + factior + '\'' +
                ", girlFriends='" + girlFriends + '\'' +
                '}';
    }
}
