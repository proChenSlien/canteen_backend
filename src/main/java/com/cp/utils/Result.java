package com.cp.utils;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;

/**
 * Created by wangsai
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
	/** 如
 	{"data":这里是你要返回的数据类型,
 	 "status":1,
 	 "msg":"操作成功"}
	*/
public class Result<T> implements Serializable {

    private int code;
    private String msg;
    private T content;

    private Result(int code){
        this.code = code;
    }
    private Result(int status, T content){
        this.code = status;
        this.content = content;
    }

    private Result(int code, String msg, T content){
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    private Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isOk(){
        return this.code == ResultCode.SUCCESS.getCode();
    }

    public int getCode(){
        return code;
    }
    public T getContent(){
        return content;
    }
    public String getMsg(){
        return msg;
    }


    public static <T> Result<T> createBySuccess(){
        return new Result<T>(ResultCode.SUCCESS.getCode());
    }

    public static <T> Result<T> createBySuccessMessage(String msg){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> createBySuccess(T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),data);
    }

    public static <T> Result<T> createBySuccess(String msg, T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> Result<T> createByError(){
        return new Result<T>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getDesc());
    }


    public static <T> Result<T> createByErrorMessage(String errorMessage){
        return new Result<T>(ResultCode.ERROR.getCode(),errorMessage);
    }

    public static <T> Result<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new Result<T>(errorCode,errorMessage);
    }

}
