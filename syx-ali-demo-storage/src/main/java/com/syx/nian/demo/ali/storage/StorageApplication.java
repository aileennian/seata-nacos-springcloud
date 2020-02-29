package com.syx.nian.demo.ali.storage;

import com.syx.nian.demo.ali.core.spring.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;



@SpringBootApplication(
    scanBasePackages = {
            "com.syx.nian.demo.ali.storage.*",
            "com.syx.nian.demo.ali.core.spring.cloud.nacos",
            "com.syx.nian.demo.ali.core.spring.cloud.seata"
    },
    exclude = {DataSourceAutoConfiguration.class})
@Import(SpringUtils.class)
public class StorageApplication {
    public static void main(String[] args){
        SpringApplication.run(StorageApplication.class, args);
    }

}
