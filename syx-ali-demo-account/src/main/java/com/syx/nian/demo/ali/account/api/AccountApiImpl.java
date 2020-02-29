package com.syx.nian.demo.ali.account.api;

import com.syx.nian.demo.ali.account.feign.AccountApi;
import com.syx.nian.demo.ali.account.service.AccountService;
import com.syx.nian.demo.ali.core.model.vo.DebitVo;
import com.syx.nian.demo.ali.core.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class AccountApiImpl implements AccountApi {
    private final AccountService accountService;
    @Override
    public R<Integer> debit(String userId, BigDecimal money) {
        Integer ret = accountService.debit(userId,money);
        return R.OK(ret);
    }

    @Autowired
    public AccountApiImpl(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public R<String> home() {
        return R.OK("You are welcome!");
    }


}
