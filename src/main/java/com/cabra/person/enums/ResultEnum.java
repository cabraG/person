package com.cabra.person.enums;

public enum ResultEnum {
    UNKOWN_ERROR(69,"unknow error"),
    SUCCESS(0,"success"),
    TEN(100,"you are under 10"),
    SIXTE(200,"you are under 16"),
    ;
    private  Integer code;
    private String msg;
    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
