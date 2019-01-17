package com.ps.enumdemo.model;

public enum GenderEnum {
    MALE(1),
    FEMAIL(2);
    private Integer value;
    GenderEnum(Integer value){
        this.value = value;
    }
    public Integer getValue(){
        return this.value;
    }
}
