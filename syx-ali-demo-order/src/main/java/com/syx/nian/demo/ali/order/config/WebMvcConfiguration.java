package com.syx.nian.demo.ali.order.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.syx.nian.demo.ali.core.apiversion.CustomRequestMappingHandlerMapping;
import com.syx.nian.demo.ali.core.constant.Constant;
import com.syx.nian.demo.ali.core.spring.SpringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.print.attribute.standard.Media;

@Configuration
@Import(SpringUtils.class)
public class WebMvcConfiguration extends WebMvcConfigurationSupport implements InitializingBean, DisposableBean {

	@Override
	protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {return new CustomRequestMappingHandlerMapping();}


	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars*").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		super.addResourceHandlers(registry);
	}



	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));

		converters.add(stringConverter);


		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setCharset(Charset.forName("UTF-8"));
//		SerializerFeature[] featureSecure = new SerializerFeature[]{
//			SerializerFeature.BrowserSecure,
//			SerializerFeature.DisableCircularReferenceDetect
//		};
//		fastJsonConfig.setSerializerFeatures(featureSecure);
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

		FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
		fastJsonConverter.setFastJsonConfig(fastJsonConfig);
		fastJsonConverter.setSupportedMediaTypes(Constant.SupportedMediaTypes);
		converters.add(fastJsonConverter);
		super.configureMessageConverters(converters);

	}


	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false); // 支持后缀匹配
	}



	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public void destroy() throws Exception {

	}



}
