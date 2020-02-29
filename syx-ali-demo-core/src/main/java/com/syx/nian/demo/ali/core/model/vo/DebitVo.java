package com.syx.nian.demo.ali.core.model.vo;

import java.math.BigDecimal;

/**
 *
 */
public class DebitVo {
    private String userId;
    private BigDecimal money;

    public DebitVo(String userId, BigDecimal money) {
        this.userId = userId;
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
