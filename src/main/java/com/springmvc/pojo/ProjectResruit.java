package com.springmvc.pojo;

import java.util.Date;

/**
 * @author XX
 *
 */
public class ProjectResruit {
    private String id;
    private String recruitTitle;
    private String recruitIntroduce;
    private String recruitSelectStandard;
    private String recruitPatientBenefit;
    private String diseaseTypeId;
    private String hospitalId;
    private Date recruitTime;
    private String researcher;
    private String bidParty;
    private String hospitalName;
    private String hospitalRegion;

    private String state;
    private  String enrollmode;//报名方式

    private String selectlist; //医院的选择列表

    public String getSelectlist() {
        return selectlist;
    }

    public void setSelectlist(String selectlist) {
        this.selectlist = selectlist;
    }

    public String getEnrollmode() {
        return enrollmode;
    }

    public void setEnrollmode(String enrollmode) {
        this.enrollmode = enrollmode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getBidParty() {
        return bidParty;
    }

    public void setBidParty(String bidParty) {
        this.bidParty = bidParty;
    }

    public String getResearcher() {
        return researcher;
    }

    public void setResearcher(String researcher) {
        this.researcher = researcher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecruitTitle() {
        return recruitTitle;
    }

    public void setRecruitTitle(String recruitTitle) {
        this.recruitTitle = recruitTitle;
    }

    public String getRecruitIntroduce() {
        return recruitIntroduce;
    }

    public void setRecruitIntroduce(String recruitIntroduce) {
        this.recruitIntroduce = recruitIntroduce;
    }

    public String getRecruitSelectStandard() {
        return recruitSelectStandard;
    }

    public void setRecruitSelectStandard(String recruitSelectStandard) {
        this.recruitSelectStandard = recruitSelectStandard;
    }

    public String getRecruitPatientBenefit() {
        return recruitPatientBenefit;
    }

    public void setRecruitPatientBenefit(String recruitPatientBenefit) {
        this.recruitPatientBenefit = recruitPatientBenefit;
    }

    public String getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(String diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Date getRecruitTime() {
        return recruitTime;
    }
    public void setRecruitTime(Date recruitTime) {
        this.recruitTime = recruitTime;
    }


}
