package com.syx.nian.demo.ali.order.dao;


import com.syx.nian.demo.ali.core.model.entity.BusinessOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface OrderDAO {

    @Insert("INSERT INTO business_order(user_id,commodity_code,count,money) values(#{userId},#{commodityCode},#{count},#{money})")
    @Options(useGeneratedKeys=true, keyProperty="orderId", keyColumn="id")
    Integer insert(BusinessOrder order);
}
