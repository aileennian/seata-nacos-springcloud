package com.syx.nian.demo.ali.order.service;


import com.syx.nian.demo.ali.account.feign.AccountApi;
import com.syx.nian.demo.ali.core.model.dto.BusinessDTO;
import com.syx.nian.demo.ali.core.model.entity.BusinessOrder;
import com.syx.nian.demo.ali.core.util.BusinessException;
import com.syx.nian.demo.ali.core.util.R;
import com.syx.nian.demo.ali.order.dao.OrderDAO;

import com.syx.nian.demo.ali.storage.feign.StorageApi;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private StorageApi storageApi;
    @Autowired
    private AccountApi accountApi;


    /**
     * 订单的分布式事务
     * 帐户
     * @param userId
     * @param commodityCode
     * @param orderCount
     * @return
     */
    @Override
    public int create(String userId, String commodityCode, int orderCount, BigDecimal orderMoney) {
        BusinessOrder order = new BusinessOrder();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
        return orderDAO.insert(order);
    }



   // @Override
    BigDecimal calculate(String commodityCode, int orderCount) {
        return BigDecimal.valueOf(9.9);
    }

    /**
     * 用户id
     * 商品编写
     * 订单数
     * ${spring.cloud.alibaba.seata.tx-service-group}
      */
    @Override
    @GlobalTransactional(name = "${spring.cloud.alibaba.seata.tx-service-group}",timeoutMills = 300000,rollbackFor = Exception.class) //此注解开启全局事务
    public R<String> purchase(BusinessDTO businessDTO) {
        BigDecimal orderMoney = calculate(businessDTO.getCommodityCode(), businessDTO.getCount());   //计算费用
        //本地方法，创建订单
        int i= create(businessDTO.getUserId(), businessDTO.getCommodityCode(), businessDTO.getCount(),orderMoney);
        if (i==0){
            throw  new BusinessException("添加订单不成功！");
        }
        //远程方法 扣减库存
        storageApi.deduct(businessDTO.getCommodityCode(), businessDTO.getCount());

        ////远程方法 扣减账户余额  可在accountServiceImpl中模拟异常
        accountApi.debit(businessDTO.getUserId(), orderMoney);

        return R.OK();
    }

}
