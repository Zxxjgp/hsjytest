package com.springmvc.pojo;

import java.io.Serializable;

/**
 *
 */
public class DiseaseType  implements Serializable{

    private static final long serialVersionUID = 9140338977482685883L;
    private String id;
    private String category;
    private  String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "DiseaseType{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
