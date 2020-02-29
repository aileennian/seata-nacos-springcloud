package com.syx.nian.demo.ali.order.config.seata;


//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.DependsOn;
//import com.syx.nian.demo.ali.core.spring.SpringUtils;
//import org.springframework.context.annotation.ComponentScan;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@ConditionalOnProperty(
        prefix = "spring.cloud.alibaba.seata",
        name = {"enabled"},
        havingValue = "true",
        matchIfMissing = true
)
@EnableConfigurationProperties({SeataConfigProperties.class})
public class SeataAutoConfig {

    @Autowired
    private SeataConfigProperties seataConfigProperties;

    /**
     * init global transaction scanner
     * @Return: GlobalTransactionScanner
     */
    @Bean
    @ConditionalOnMissingBean({GlobalTransactionScanner.class})
    public GlobalTransactionScanner globalTransactionScanner() {
        String appId =  seataConfigProperties.getApplicationId();
        String txServiceGroup = seataConfigProperties.getTxServiceGroup();
        GlobalTransactionScanner transactionScanner = new GlobalTransactionScanner(appId, txServiceGroup);
        //seataProperties.setEnabled(true);
        return transactionScanner;
    }
}
