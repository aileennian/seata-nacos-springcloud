package com.syx.nian.demo.ali.core.model.entity;


import com.syx.nian.demo.ali.core.model.BaseMode;

import java.io.Serializable;
import java.util.Date;

public class Account extends BaseMode<Account> {
    private Long id;
    private String userId;
    private Double money;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
