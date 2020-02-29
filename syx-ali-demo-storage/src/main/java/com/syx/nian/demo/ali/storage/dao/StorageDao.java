package com.syx.nian.demo.ali.storage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StorageDao {
    /**
     * 减掉库存
     * @param count
     * @param commodityCode
     * @return
     */
    @Update("UPDATE storage SET count=(count-#{count}) WHERE commodity_code=#{commodityCode} and count>=#{count}")
    int updateCount(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
