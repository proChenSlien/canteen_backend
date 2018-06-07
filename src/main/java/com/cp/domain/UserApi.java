package com.cp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_api")
public class UserApi {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false, length = 40)
    private String id;
    @Column(name = "account_num", nullable = false, columnDefinition = "varchar(64) COMMENT '账户'")
    private Long accountNum;
    @Column(name = "password", columnDefinition = "varchar(64) COMMENT '密码'")
    private String password;
    @Column(name = "phone", nullable = false, columnDefinition = "bigint COMMENT '手机'")
    private Long phone;
    @Column(name = "user_name", nullable = false, columnDefinition = "varchar(64) COMMENT '用户名'")
    private String userName;
    @Column(name = "real_name", columnDefinition = "varchar(64) COMMENT '真实姓名'")
    private String realName;
    @Column(name = "sex", columnDefinition = "int COMMENT '性别'")
    private Integer sex;
    @Column(name = "img_show", columnDefinition = "varchar(64) COMMENT '图片'")
    private String imgShow;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "login_time_last", columnDefinition = "datetime COMMENT '最后登录时间'")
    private Date loginTimeLast;
    @Column(name = "state", nullable = false, columnDefinition = "int COMMENT '状态'")
    private Integer state;
    @Column(name = "valid", nullable = false, columnDefinition = "int COMMENT '有效性'")
    private Integer valid = 1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }



    public String getImgShow() {
        return imgShow;
    }

    public void setImgShow(String imgShow) {
        this.imgShow = imgShow;
    }

    public Date getLoginTimeLast() {
        return loginTimeLast;
    }

    public void setLoginTimeLast(Date loginTimeLast) {
        this.loginTimeLast = loginTimeLast;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
