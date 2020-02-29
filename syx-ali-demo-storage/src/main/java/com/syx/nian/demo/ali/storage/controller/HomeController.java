package com.syx.nian.demo.ali.storage.controller;


import com.syx.nian.demo.ali.core.util.R;
import com.syx.nian.demo.ali.storage.config.BootstrapProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final BootstrapProperties localConfig;

    public HomeController(BootstrapProperties localConfig) {
        this.localConfig = localConfig;
    }

    @ResponseBody
    @RequestMapping("/")
    public R<String> hello(){
        return R.OK("Welcome to "+localConfig.getSpringApplicatonName());
    }



}
