package com.cp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_form")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false, length = 40)
    private String id;
    @Column(name = "order_num", nullable = false, columnDefinition = "varchar(64) COMMENT '订单编号'")
    private String orderNum;
    @Column(name = "user_id", nullable = false, columnDefinition = "varchar(64) COMMENT '用户id'")
    private String userId;
    @Column(name = "shopping_id", nullable = false, columnDefinition = "varchar(64) COMMENT '购物车id'")
    private String shoppingId;
    @Column(name = "order_time", nullable = false, columnDefinition = "datetime COMMENT '下单时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTime;
    @Column(name = "address_id", columnDefinition = "varchar(64) COMMENT '订单地址id'")
    private String addressId;
    @Column(name = "distributor", columnDefinition = "varchar(64) COMMENT '配送员'")
    private String distributor;
    @Column(name = "reach_time", columnDefinition = "datetime COMMENT '送达时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reachTime;
    @Column(name = "require_time", columnDefinition = "datetime COMMENT '期望送达时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date requireTime;
    @Column(name = "prereach_time", columnDefinition = "datetime COMMENT '预计送达时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date prereachTime;
    @Column(name = "remark", columnDefinition = "text COMMENT '账单详情'")
    private String remark;
    @Column(name = "pay_type", columnDefinition = "int COMMENT '支付方式'")
    private Integer payType;
    @Column(name = "valid", nullable = false, columnDefinition = "int COMMENT '有效性'")
    private Integer valid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(String shoppingId) {
        this.shoppingId = shoppingId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public Date getReachTime() {
        return reachTime;
    }

    public void setReachTime(Date reachTime) {
        this.reachTime = reachTime;
    }

    public Date getRequireTime() {
        return requireTime;
    }

    public void setRequireTime(Date requireTime) {
        this.requireTime = requireTime;
    }

    public Date getPrereachTime() {
        return prereachTime;
    }

    public void setPrereachTime(Date prereachTime) {
        this.prereachTime = prereachTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
