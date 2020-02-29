package com.syx.nian.demo.ali.account.dao;

import com.syx.nian.demo.ali.core.model.entity.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface AccountDao {
    @Insert("insert into account(user_id,money) values(#{userId},#{money})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Account account);


    @Select("SELECT * FROM account WHERE user_id=#{userId}")
    @Results({ @Result(column = "create_time", property = "createTime", javaType = java.util.Date.class) })
    Account findByUserId(@Param("userId")  String userId);


    /**
     * 从用户钱包里减掉钱数
     * @param userId
     * @param money
     * @return
     */
    @Update("Update account set money=(money-#{money}) WHERE user_id=#{userId} and money>=#{money}")
    public Integer decreaseAccount(@Param("userId") String userId,@Param("money") BigDecimal money);


    /**
     * 查找全部
     *
     * @return
     */
    @Select("SELECT * FROM account")
    @Results({ @Result(column = "create_time", property = "createTime", javaType = java.util.Date.class) })
    List<Account> getAll();

    @Update("select * from t_account where user_id = #{userId} for update")
    Integer testGlobalLock(@Param("userId") String userId);
}
