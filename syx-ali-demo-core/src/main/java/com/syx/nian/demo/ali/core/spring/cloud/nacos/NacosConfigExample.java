package com.syx.nian.demo.ali.core.spring.cloud.nacos;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;


/**
 *
 * NACOS Test Metadata {@link NacosCloudConfiguration}.
 * @author <a href="mailto:nianxl@gmail.com">nianxiaoling</a>
 * @date ${date} ${time}
 */
@Configuration
@NacosConfigurationProperties(dataId = "nacos-example-common.properties", autoRefreshed = true)
public class NacosConfigExample {
   private static final Logger log = LogManager.getLogger(NacosConfigExample.class);
    private Integer amount;
    private Double price;
    private String desc;
    private String chinese;

    public static Logger getLog() {
        return log;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getChinese() {
        return "aaa"+chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "NacosConfigBootstrap{" +
                "amount=" + amount +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", chinese='" + chinese + '\'' +
                '}';
    }
}
