package com.csh.food.res.base.response;

public enum HttpResponseCodeEnum {
    SUCCESS(1,"业务成功"),
    FAIL(0,"业务失败"),
    Condition(-1,"条件不符合");

    private int code;

    private String message;

    HttpResponseCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
