package com.ps.demo.service;

import java.util.Arrays;

public enum SenderType {
    SMS(1),
    EMAIL(2);
    private Integer value;
    private SenderType(Integer value){
        this.value = value;
    }
    public static SenderType fromValue(Integer value){
        System.out.printf("sendtype: " + value.toString());
        for(SenderType type: values()){
            if(type.value.equals(type.value)){
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
