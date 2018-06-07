package com.cp.enums;

/**
 * @ClassName CardKind
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 9:42
 **/
public enum  CardKind {
    VIP_SINGLR_GYM(1L, "单人健身会员卡"),
    VIP_CHILD(2L, "亲密卡");

    private Long code;
    private String msg;

    CardKind(Long code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
