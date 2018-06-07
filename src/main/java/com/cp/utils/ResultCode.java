package com.cp.utils;

/**
 * Created by wangsai
 */
public enum ResultCode {

    SUCCESS(1,"SUCCESS"),// 成功
    ERROR(0,"ERROR"), // 失败
    EXCEPTION(-1,"EXCEPTION"),// 异常
    NEED_LOGIN(10,"NEED_LOGIN"),// 需要登录
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");// 非法参数

    private final int code;
    private final String desc;


    ResultCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
