package com.springmvc.kafaka;

public class BasicImpl implements Basic{

    @Override
    public String sayHello(String name) {
        return "This is Hello words from HESSIAN Server. " + name;
    }
}