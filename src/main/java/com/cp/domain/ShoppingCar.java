package com.cp.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "shopping_car")
public class ShoppingCar {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false, length = 40)
    private String id;
    @Column(name = "user_id", nullable = false, columnDefinition = "varchar(64) COMMENT '用户id'")
    private String userId;
    @Column(name = "car_name", columnDefinition = "varchar(64) COMMENT '购物车名称'")
    private String carName;
    @Column(name = "goods_num", nullable = false, columnDefinition = "int COMMENT '商品数量'")
    private Integer goodsNum;
    @Column(name = "total", nullable = false, columnDefinition = "double COMMENT '商品总价'")
    private double total;
    @Column(name = "dish_fee", nullable = false, columnDefinition = "double COMMENT '餐盒费'")
    private double dishFee;
    @Column(name = "distribution_fee", nullable = false, columnDefinition = "double COMMENT '配送费'")
    private double distributionFee;
    @Column(name = "state", nullable = false, columnDefinition = "int COMMENT '状态'")
    private Integer state;
    @Column(name = "valid", nullable = false, columnDefinition = "int COMMENT '有效性'")
    private Integer valid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }



    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDishFee() {
        return dishFee;
    }

    public void setDishFee(double dishFee) {
        this.dishFee = dishFee;
    }

    public double getDistributionFee() {
        return distributionFee;
    }

    public void setDistributionFee(double distributionFee) {
        this.distributionFee = distributionFee;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
