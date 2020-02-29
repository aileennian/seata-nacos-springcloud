package com.syx.nian.demo.ali.order;


import com.syx.nian.demo.ali.core.spring.SpringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


/**
 *       scanBasePackages ={
 *                "com.syx.nian.demo.ali.order"
 *        },
 */
@SpringBootApplication(
        exclude = {
        DataSourceAutoConfiguration.class
    })
public class OrderApplication {
    public static void main(String[] args){
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(OrderApplication.class, args);
//        String provider = applicationContext.getEnvironment().getProperty("amount");
//        String consumer = applicationContext.getEnvironment().getProperty("price");
//        System.err.println("provider name :" +provider+"; consumer name: "+consumer);

        SpringApplicationBuilder builder =  new SpringApplicationBuilder(OrderApplication.class);//.run(args);
        builder.run();
    }

}
