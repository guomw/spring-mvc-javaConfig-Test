package com.guomw.mvc.enums;


/**
 * @author guomw
 */
public enum ResultCodeEnum {

    /**
     * 成功
     */
    SUCCESS(1,"成功");

    private int value;

    private String name;

    ResultCodeEnum(int value, String name){
        this.value=value;
        this.name=name;
    }


    public int getResultCode() {
        return value;
    }

    public String getResultMsg() {
        return name;
    }
}
