package com.syx.nian.demo.ali.order.controller;


import com.syx.nian.demo.ali.core.util.R;
import com.syx.nian.demo.ali.order.config.BootstrapProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BootstrapProperties localConfig;


    @ResponseBody
    @RequestMapping(value={"/","hello"})
    public R<String> hello(){
        return R.OK("Welcome to "+localConfig.getSpringApplicatonName());
    }

    @ResponseBody
    @RequestMapping(value="")
    public R<String> home(){
        return R.OK("Welcome to "+localConfig.getSpringApplicatonName());
    }

}
