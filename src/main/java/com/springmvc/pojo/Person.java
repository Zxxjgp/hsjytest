package com.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Person {
    private String id;
    private String useranme;
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUseranme() {
        return useranme;
    }

    public void setUseranme(String useranme) {
        this.useranme = useranme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
