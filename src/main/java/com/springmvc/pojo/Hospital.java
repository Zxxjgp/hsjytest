package com.springmvc.pojo;

public class Hospital {
    private String id;
    private String hospitalName;
    private String hospitalRegion;
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalRegion() {
        return hospitalRegion;
    }

    public void setHospitalRegion(String hospitalRegion) {
        this.hospitalRegion = hospitalRegion;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
