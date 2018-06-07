package com.cp.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @ClassName UseState
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 14:16
 **/
public enum Status {

    FALSE(0, "无效"),
    TRUE(1, "有效");

    private Integer code;
    private String msg;

    Status(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Map toMap() {
        Map map = Maps.newHashMap();
        map.put("status", code);
        map.put("msg", msg);
        return map;
    }
}
