package com.springmvc.xtream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
public class Demo {
   
    public static void main(String[] args) throws Exception {  
        JAXBContext jc = JAXBContext.newInstance(Customer.class);  
   
        Customer customer = new Customer();  
        customer.getEmailAddresses().add("janed@example.com");  
        customer.getEmailAddresses().add("jdoe@example.org");  
   
        Marshaller marshaller = jc.createMarshaller();  
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
        marshaller.marshal(customer, System.out);  
    }  
}  
