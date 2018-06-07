package com.cp.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_address")
public class Address {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id",unique = true, nullable = false, length = 40)
    private String id;
    @Column(name = "user_id", columnDefinition = "varchar(64) COMMENT '用户id'")
    private String userId;
    @Column(name = "address", nullable = false, columnDefinition = "varchar(255) COMMENT '配送地址'")
    private String address;
    @Column(name = "state", columnDefinition = "int COMMENT '启用状态'")
    private Integer state;
    @Column(name = "is_default", columnDefinition = "int COMMENT '默认状态'")
    private Integer isDefault;
    @Column(name = "valid", columnDefinition = "int COMMENT '有效性'")
    private Integer valid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
