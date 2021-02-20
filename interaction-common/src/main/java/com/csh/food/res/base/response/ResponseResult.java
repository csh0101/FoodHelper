package com.csh.food.res.base.response;

public class ResponseResult<T> {
    private int code = 0;
    private String msg;
    private T data;

    public ResponseResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static  ResponseResult success(){
        return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(),ResponseCodeEnum.SUCCESS.getMessage());
    }
    //http 200
    public static <T> ResponseResult<T> success(T data){
        return new ResponseResult(HttpResponseCodeEnum.SUCCESS.getCode(),HttpResponseCodeEnum.SUCCESS.getMessage(),data);
    }
    //http 500
    public static <T> ResponseResult<T> error(T data){
        return new ResponseResult(HttpResponseCodeEnum.FAIL.getCode(),HttpResponseCodeEnum.FAIL.getMessage(),data);
    }


    public static ResponseResult error(int code,String msg){
        return new ResponseResult(code,msg);
    }

    public static <T> ResponseResult<T> error(int code,String msg,T data){
        return new ResponseResult<>(code,msg,data);
    }

    public boolean isSuccess(){
        return code == 0;
    }

    public int getCode(){
        return code;
    }
    public void setCode(){
        this.code = code;
    }
    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }
}
