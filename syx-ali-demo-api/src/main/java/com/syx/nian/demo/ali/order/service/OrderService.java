package com.syx.nian.demo.ali.order.service;


import com.syx.nian.demo.ali.core.model.dto.BusinessDTO;
import com.syx.nian.demo.ali.core.util.R;

import java.math.BigDecimal;


public interface OrderService {
    //创建订单
    int create(String userId, String commodityCode, int orderCount, BigDecimal money);

    //下单采购--主事务入口
    public R<String> purchase(BusinessDTO businessDTO);
}
