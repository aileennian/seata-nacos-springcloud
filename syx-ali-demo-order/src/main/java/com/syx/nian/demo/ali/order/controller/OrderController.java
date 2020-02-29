package com.syx.nian.demo.ali.order.controller;
import com.syx.nian.demo.ali.core.model.dto.BusinessDTO;
import com.syx.nian.demo.ali.core.util.R;
import com.syx.nian.demo.ali.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


/**
 * 订单测试
 */
@RestController
@RequestMapping("/business")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @RequestMapping("/createOrder")
    public R<String> createOrder(BusinessDTO dto){
        //int create(String userId, String commodityCode, int orderCount, BigDecimal money);
        int i = orderService.create(dto.getUserId(),dto.getCommodityCode(),dto.getCount(),dto.getAmount());
        return R.OK(String.valueOf(i));
    }

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @RequestMapping("/purchase/")
    public R<String> purchase(BusinessDTO businessDTO){
        R<String> re = orderService.purchase(businessDTO);
        return re;
    }
}
