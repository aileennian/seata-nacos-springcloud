package com.syx.nian.demo.ali.order.config;


import com.syx.nian.demo.ali.account.feign.AccountApi;
import com.syx.nian.demo.ali.core.model.entity.Storage;
import com.syx.nian.demo.ali.storage.feign.StorageApi;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.concurrent.TimeUnit;


@Configuration
@EnableFeignClients(basePackages = {
         "com.syx.nian.demo.ali.account.feign*"
        ,"com.syx.nian.demo.ali.storage.feign"
})
public class FeignApiAutoConfig {
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }

}
