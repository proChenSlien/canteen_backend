package com.cp.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "goods_type")
public class GoodsType {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false, length = 40)
    private String id;
    @Column(name = "type_name", nullable = false, columnDefinition = "varchar(64) COMMENT '类型名称'")
    private String typeName;
    @Column(name = "valid", nullable = false, columnDefinition = "int COMMENT '有效性'")
    private Integer valid = 1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
