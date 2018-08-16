package com.springmvc.xtream;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)  
public class Customer {
    @XmlElement(name="email-----------address")
    private List<String> emailAddresses;
       
    public Customer() {  
        emailAddresses = new ArrayList<String>();
    }  
   
    public List<String> getEmailAddresses() {  
        return emailAddresses;  
    }  
   
    public void setEmailAddresses(List<String> emailAddresses) {  
        this.emailAddresses = emailAddresses;  
    }  
   
}  