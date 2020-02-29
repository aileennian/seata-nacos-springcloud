package com.syx.nian.demo.ali.account.service;


import com.syx.nian.demo.ali.account.dao.AccountDao;
import com.syx.nian.demo.ali.core.model.entity.Account;
import com.syx.nian.demo.ali.core.util.BusinessException;
import io.seata.spring.annotation.GlobalLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户购买
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 减钱
     * @param userId
     * @param money
     */
    @Override
    public Integer debit(String userId, BigDecimal money) {
        Integer re = accountDao.decreaseAccount(userId,money);
        if (re==null || re>0){
            //成功
        }else{
            throw new BusinessException("用户不存在或者钱包的费用不足！");
        }
        return re;
    }

    @Override
    public List<Account> listAccount() {
        List<Account> list = accountDao.getAll();
        return list;
    }

    /**
     * 脏写：@GlobalTransaction
     * @return
     */
    @Override
    @GlobalLock
    @Transactional(rollbackFor = {Throwable.class})
    public Integer testGlobalLock() {
        Integer re= accountDao.testGlobalLock("1");
        System.out.println("Hi, i got lock, i will do some thing with holding this lock.");
        return re;
    }
    
}
