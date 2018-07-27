package com.springmvc.test.bean;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import java.util.List;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.test.bean
 * @ClassName: Person
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/7/26 16:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/7/26 16:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Person {
    private String id;
    private String name ;
    private String sex;
    private Student student;

    private List<Student> list;

    public Person(String id, String name, String sex, Student student,List<Student> list) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.student = student;
        this.list = list;
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person(List<Student> list) {
        this.list = list;
    }

    public Person() {
    }


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", student=" + student +
                ", list=" + list +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
