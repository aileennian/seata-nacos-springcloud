package com.syx.nian.demo.ali.order.config.nacos;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.syx.nian.demo.ali.core.constant.Constant;
import com.syx.nian.demo.ali.core.spring.cloud.nacos.NacosConfigExample;
import com.syx.nian.demo.ali.order.config.BootstrapProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/*
 * @ConditionalOnClass，当classpath下发现该类的情况下进行自动配置。
 * @ConditionalOnMissingBean，当Spring Context中不存在该Bean时进行自动配置。
 * @ConditionalOnProperty(name = NacosConfigConstants.ENABLED, matchIfMissing = true)时进行自动配置。
 */
@Configuration
@EnableDiscoveryClient
public class NacosCloudConfiguration {
    private static Logger log = LogManager.getLogger(NacosCloudConfiguration.class);

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(Constant.SupportedMediaTypes);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setFastJsonConfig(fastJsonConfig);

        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        converters.removeIf(c -> c instanceof MappingJackson2HttpMessageConverter);
        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        converters.add(converter);
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }


    @RestController
    public class TestNacosDiscoveryController {
        private final Logger log = LogManager.getLogger(com.syx.nian.demo.ali.core.spring.cloud.nacos.NacosCloudConfiguration.TestNacosDiscoveryController.class);
        private RestTemplate restTemplate;

        @Value("${spring.application.name}")
        private String applicationName;
        @Autowired
        public TestNacosDiscoveryController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        /**
         * 作为消费者，将信息给提供者
         * @param str
         * @return
         */
        @RequestMapping(value = "/echo/nacos/{str}", method = RequestMethod.GET)
        public String echonacos( @PathVariable String str,String provider) {
            if (provider==null){
                provider = applicationName;
            }
            String requestURL =  new StringBuffer("http://").append(provider).append("/echo/nacos/provider/").append(str).toString();
            log.info("requestURL="+requestURL);
            return restTemplate.getForObject(requestURL, String.class);
        }

        /**
         * 作为服务提供者，返回消息给消费者
         * @param string
         * @return
         */
        @RequestMapping(value = "/echo/nacos/provider/{string}", method = RequestMethod.GET)
        public String providerEcho(@PathVariable String string) {
            return "Hello Nacos Discovery,  '" + string + "' is your request content! My name is "+ this.applicationName;
        }
    }


    @RestController
    @RefreshScope
    public class TestNacosConifgController {
        private final Logger log = LogManager.getLogger(com.syx.nian.demo.ali.core.spring.cloud.nacos.NacosCloudConfiguration.TestNacosConifgController.class);

        @Value("${spring.application.name}")
        private String provider;

        @NacosProperty("amount")
        private String amount;

        private final NacosConfigBootstrap nacosConfigBootstrap;

        @Autowired
        public TestNacosConifgController(NacosConfigBootstrap nacosConfigBootstrap) {
            this.nacosConfigBootstrap = nacosConfigBootstrap;
        }

        /**
         * 从默认的nacos配置文件中取得属性
         * <spring.application.name>-<spring.profiles.active>.properties
         * @return
         */
        @RequestMapping(value = "/echo/nacos/config/default", method = RequestMethod.GET)
        public String getProvider() {
            return provider;
        }

        @RequestMapping(value = "/echo/nacos/config/sharedfiles", method = RequestMethod.GET)
        public String getAmount() {
            return "amount="+amount;
        }


        @RequestMapping(value = "/echo/nacos/config/java", method = RequestMethod.GET)
        public String getProviderJava() {
            return nacosConfigBootstrap.toString();
        }

    }
}
