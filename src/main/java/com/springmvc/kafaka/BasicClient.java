package com.springmvc.kafaka;

import com.caucho.hessian.client.HessianProxyFactory;

public class BasicClient {
    public static void main(String[] args) {
        try {
            String url = "http://localhost:8080/hessian";
            HessianProxyFactory factory = new HessianProxyFactory();
            factory.setOverloadEnabled(true);
            Basic basic = (Basic) factory.create(Basic.class, url);
            System.out.println(basic.sayHello("1111111111111111"));
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}