package com.cp.dto.vo;

import java.io.Serializable;

/**
 * @author: Slien
 * @Date: 2018-06-04 10:27
 */
public class GoodsVo implements Serializable {
    private String id;
    private String goodsName;
    private String typeName;
    private Double price;
    private String img;
    private String remark;
    private Integer stock;
    private Integer volumeDay;
    private Integer volumeMonth;
    private Integer volumeYear;
    private Integer state;
    private Integer valid;

    public GoodsVo(String id, String goodsName, String typeName, Double price, String img, String remark, Integer stock,
                    Integer volumeDay, Integer volumeMonth, Integer volumeYear, Integer state, Integer valid){
        this.id = id;
        this.goodsName = goodsName;
        this.typeName = typeName;
        this.price = price;
        this.img = img;
        this.remark = remark;
        this.stock = stock;
        this.volumeDay = volumeDay;
        this.volumeMonth = volumeMonth;
        this.volumeYear = volumeYear;
        this.state = state;
        this.valid = valid;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getVolumeDay() {
        return volumeDay;
    }

    public void setVolumeDay(Integer volumeDay) {
        this.volumeDay = volumeDay;
    }

    public Integer getVolumeMonth() {
        return volumeMonth;
    }

    public void setVolumeMonth(Integer volumeMonth) {
        this.volumeMonth = volumeMonth;
    }

    public Integer getVolumeYear() {
        return volumeYear;
    }

    public void setVolumeYear(Integer volumeYear) {
        this.volumeYear = volumeYear;
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
