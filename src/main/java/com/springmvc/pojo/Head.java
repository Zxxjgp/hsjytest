package com.springmvc.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.pojo
 * @ClassName: Head
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/8/15 21:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/8/15 21:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@XmlRootElement
@XStreamAlias("XMLXMLXMLXXLMXLXMXLMXL")
public class Head {

    private String GUOJIA;
    private String SHENFEN;
    private String SHIQU;
    private String BIANHAO;
    @XStreamAlias("Body")
    private Boday  bodays;
    @XStreamAsAttribute
    @XStreamAlias("class")
    private String Class ;



    public void setClass(String aClass) {
        Class = aClass;
    }

    public String getGUOJIA() {
        return GUOJIA;
    }

    public void setGUOJIA(String GUOJIA) {
        this.GUOJIA = GUOJIA;
    }

    public String getSHENFEN() {
        return SHENFEN;
    }

    public void setSHENFEN(String SHENFEN) {
        this.SHENFEN = SHENFEN;
    }

    public String getSHIQU() {
        return SHIQU;
    }

    public void setSHIQU(String SHIQU) {
        this.SHIQU = SHIQU;
    }

    public String getBIANHAO() {
        return BIANHAO;
    }

    public void setBIANHAO(String BIANHAO) {
        this.BIANHAO = BIANHAO;
    }

    public Boday getBodays() {
        return bodays;
    }

    public void setBodays(Boday bodays) {
        this.bodays = bodays;
    }

    @Override
    public String toString() {
        return "Head{" +
                "GUOJIA='" + GUOJIA + '\'' +
                ", SHENFEN='" + SHENFEN + '\'' +
                ", SHIQU='" + SHIQU + '\'' +
                ", BIANHAO='" + BIANHAO + '\'' +
                ", bodays=" + bodays +
                ", Class='" + Class + '\'' +
                '}';
    }
}
