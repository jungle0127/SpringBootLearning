package com.ps.demo.service;

import java.beans.PropertyEditorSupport;

/**
 * https://www.devglan.com/spring-boot/enums-as-request-parameters-in-spring-boot-rest
 * https://machiel.me/post/java-enums-as-request-parameters-in-spring-4/
 */
public class SenderTypeConverter extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.printf("converter runned=================");
        System.out.printf("Sendertypeconverter: " + text);
        setValue(SenderType.fromValue(Integer.valueOf(text)));
    }
}
