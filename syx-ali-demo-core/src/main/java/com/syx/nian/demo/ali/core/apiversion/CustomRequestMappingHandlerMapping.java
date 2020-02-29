package com.syx.nian.demo.ali.core.apiversion;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 用法
 * http://Ip:port/api/v1/hello
 *  http://Ip:port/api/hello ？？未测试
 * http://Ip:port/api/v2/hello
 * http://Ip:port/api/v3/hello  最大版本号原则
 *
 *
 * 前提条修的入Bean
 * @Configuration
 * public class WebMvcConfiguration extends WebMvcConfigurationSupport {
 * *
 *    @Override
 *    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
 * 		return new CustomRequestMappingHandlerMapping();
 *    }
 *
 *   在2.2.x的Spring版本中
 *  @Override
 * 	protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
 * 		return new CustomRequestMappingHandlerMapping();
 * 	}
 * }
 *
 */
public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        //scan @ApiVersion
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);

        return createRequestCondition(apiVersion);
    }



    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        //scan @ApiVersion
        final ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return createRequestCondition(apiVersion);
    }


    private RequestCondition<ApiVersionCondition> createRequestCondition(final ApiVersion apiVersion){
        if (Objects.isNull(apiVersion)) {
            return null;
        }
        //int value = apiVersion.value();
        Assert.isTrue(apiVersion.value() >= 1, "Api Version Must be greater than or equal to 1");
        return new ApiVersionCondition(apiVersion.value());
    }



}
