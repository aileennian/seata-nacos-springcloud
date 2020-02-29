package com.syx.nian.demo.ali.account;

import com.syx.nian.demo.ali.core.spring.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication(
        scanBasePackages = {
                "com.syx.nian.demo.ali.account",
                "com.syx.nian.demo.ali.core.spring.cloud.nacos",
                "com.syx.nian.demo.ali.core.spring.cloud.seata"
        },
        exclude = {DataSourceAutoConfiguration.class})
public class AccountApplication {
    public static void main(String[] args){
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConsumerApplication.class, args);
//        String provider = applicationContext.getEnvironment().getProperty("amount");
//        String consumer = applicationContext.getEnvironment().getProperty("price");
//        System.err.println("provider name :" +provider+"; consumer name: "+consumer);

        //new SpringApplicationBuilder().build().run(arg);

        SpringApplication.run(AccountApplication.class, args);
    }

}
