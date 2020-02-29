package com.syx.nian.demo.ali.core.model.entity;


import com.syx.nian.demo.ali.core.model.BaseMode;
import com.syx.nian.demo.ali.core.model.dto.BusinessDTO;

public class Storage extends BaseMode<BusinessDTO> {
    private Long storageId;
    private String commodityCode;
    private Integer count;
    private Double price;

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
