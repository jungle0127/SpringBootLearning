package com.ps.demo.service;

import java.beans.PropertyEditorSupport;

/**
 * https://www.devglan.com/spring-boot/enums-as-request-parameters-in-spring-boot-rest
 * https://machiel.me/post/java-enums-as-request-parameters-in-spring-4/
 */
public class SenderTypeConverter extends PropertyEditorSupport {
    @Override
    public void setValue(Object value) {
        if(value == null){
            System.out.println("its n ull.");
        }
        System.out.printf("check");
        super.setValue(value);
    }

    @Override
    public void setSource(Object source) {
        Message msg = (Message)source;
        msg.getSenderType();
        if(source instanceof Message){
            System.out.println("sendertype");
        } else if(source instanceof String){
            System.out.println("string");
        }
        else
        {
            System.out.println("unknown");
        }
        System.out.println("check");
        super.setSource(source);

    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.printf("converter runned=================");
        System.out.printf("Sendertypeconverter: " + text);
        setValue(SenderType.fromValue(Integer.valueOf(text)));
    }
}
