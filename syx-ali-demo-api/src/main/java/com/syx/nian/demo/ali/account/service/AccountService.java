package com.syx.nian.demo.ali.account.service;

import com.syx.nian.demo.ali.core.model.entity.Account;

import java.math.BigDecimal;
import java.util.List;


public interface AccountService {
    /**
     * 扣除帐户金额
     */
   Integer debit(String userId, BigDecimal money);

    List<Account> listAccount();

    /**
     * 获得锁
     * @return
     */
    Integer testGlobalLock();
}
