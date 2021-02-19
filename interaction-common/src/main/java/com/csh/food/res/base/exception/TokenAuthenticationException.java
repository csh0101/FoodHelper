package com.csh.food.res.base.exception;

public class TokenAuthenticationException extends RuntimeException {
    private int code;
    private String msg;
    public TokenAuthenticationException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
