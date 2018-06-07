package com.cp.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false, length = 40)
    private String id;
    @Column(name = "goods_name", nullable = false, columnDefinition = "varchar(64) COMMENT '商品名称'")
    private String goodsName;
    @Column(name = "type_id", nullable = false, columnDefinition = "varchar(64) COMMENT '商品类型'")
    private String typeId;
    @Column(name = "price", nullable = false, columnDefinition = "double COMMENT '商品单价'")
    private Double price;
    @Column(name = "img", columnDefinition = "varchar(64) COMMENT '商品图片'")
    private String img;
    @Column(name = "remark", columnDefinition = "text COMMENT '商品说明'")
    private String remark;
    @Column(name = "stock", columnDefinition = "int COMMENT '库存'")
    private Integer stock;
    @Column(name = "volume_day",  columnDefinition = "int COMMENT '日销量'")
    private Integer volumeDay = 0;
    @Column(name = "volume_month", columnDefinition = "int COMMENT '月销量'")
    private Integer volumeMonth = 0;
    @Column(name = "volume_year", columnDefinition = "int COMMENT '年销量'")
    private Integer volumeYear = 0;
    @Column(name = "state", nullable = false, columnDefinition = "int COMMENT '状态上下架'")
    private Integer state;
    @Column(name = "valid", nullable = false, columnDefinition = "int COMMENT '有效性'")
    private Integer valid = 1;

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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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
