package com.cp.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @ClassName UseState
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 14:16
 **/
public enum UseState {

    UN_USE(0, "未开通"),
    IN_USE(1, "已开通"),
    NO_USE(2, "已过期");

    private Integer code;
    private String msg;

    UseState(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Map toMap() {
        Map map = Maps.newHashMap();
        map.put("status", code);
        map.put("msg", msg);
        return map;
    }
}
