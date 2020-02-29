package com.syx.nian.demo.ali.account.controller;


import com.syx.nian.demo.ali.account.config.BootstrapProperties;
import com.syx.nian.demo.ali.account.service.AccountService;
import com.syx.nian.demo.ali.core.model.entity.Account;
import com.syx.nian.demo.ali.core.util.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private static Logger log = LogManager.getLogger(HomeController.class);

    @Autowired
    private BootstrapProperties localConfig;

    @Autowired
    private AccountService accountService;




    @RequestMapping("/")
    public R<String> hello(){
        return R.OK("Welcome to "+localConfig.getSpringApplicatonName());
    }


    @RequestMapping("/test/listAccount")
    R<List<Account>> testListAccount() {
        log.info("testlistAccount");
        return R.OK(accountService.listAccount());
    }


    @RequestMapping("/test/lobalLock")
    R<Integer> testGlobalLock() {
        log.info("testglobalLock");
        Integer i = accountService.testGlobalLock();
        return R.OK(i);
    }

}
