package com.syx.nian.demo.ali.core.model.entity;


import com.syx.nian.demo.ali.core.model.BaseMode;
import com.syx.nian.demo.ali.core.model.dto.BusinessDTO;

import java.math.BigDecimal;


public class BusinessOrder extends BaseMode<BusinessDTO>{
    private Long orderId;
    private String userId;
    private  String commodityCode;
    private Integer count;
    private BigDecimal money;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
