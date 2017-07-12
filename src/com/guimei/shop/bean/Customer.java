package com.guimei.shop.bean;

import com.wang.db2.Column;
import com.wang.db2.Id;
import com.wang.db2.Ignore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * by wangrongjun on 2017/6/16.
 */
@Entity
public class Customer {

    @Ignore
    public static final int GENDER_WOMAN = 0;
    @Ignore
    public static final int GENDER_MAN = 1;

    @Id
    @javax.persistence.Id
    @GeneratedValue
    private int customerId;
    @Column(length = 20, nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private String password;
    private String realName;
    private String nickname;
    private int gender;
    private String headUrl;

    public Customer() {
    }

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public Customer(String phone, String password, String realName, String nickname,
                    int gender, String headUrl) {
        this.phone = phone;
        this.password = password;
        this.realName = realName;
        this.nickname = nickname;
        this.gender = gender;
        this.headUrl = headUrl;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
