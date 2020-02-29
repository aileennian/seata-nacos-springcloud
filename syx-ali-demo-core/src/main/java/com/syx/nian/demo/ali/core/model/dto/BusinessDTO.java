package com.syx.nian.demo.ali.core.model.dto;

import com.syx.nian.demo.ali.core.model.BaseMode;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BusinessDTO extends BaseMode<BusinessDTO> {

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 商品编码
     */
    private String commodityCode;

    /**
     * 名字
     */
    private String name;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private BigDecimal amount;

}
