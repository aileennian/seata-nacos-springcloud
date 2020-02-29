package com.syx.nian.demo.ali.storage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource(value = "classpath:bootstrap.properties")
public class BootstrapProperties {
    @Value("${spring.application.name}")
    private String springApplicatonName;


    public String getSpringApplicatonName() {
        return springApplicatonName;
    }

    public void setSpringApplicatonName(String springApplicatonName) {
        this.springApplicatonName = springApplicatonName;
    }
}
