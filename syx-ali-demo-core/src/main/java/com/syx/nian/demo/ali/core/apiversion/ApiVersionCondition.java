package com.syx.nian.demo.ali.core.apiversion;

import lombok.Data;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 原理
 *  当方法级别和类级别都有ApiVersion注解时，
 *  二者将进行合并（ApiVersionRequestCondition.combine）。
 *  最终将提取请求URL中版本号，与注解上定义的版本号进行比对，判断url是否符合版本要求。
 */
@Data
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    /**
     * 接口路径中的版本号前缀，如: api/v[1-n]/test
     */
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("/v(\\d+)/");

    private int version;
    ApiVersionCondition(int version) {
        this.version = version;
    }

    //将不同的筛选条件合并
    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        // 最近优先原则，方法定义的 @ApiVersion > 类定义的 @ApiVersion
        return new ApiVersionCondition(apiVersionCondition.getVersion());
    }

    /**
     *  //根据request查找匹配到的筛选条件,
     * 版本号实现
     * @param httpServletRequest
     * @return
     */
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (m.find()) {
            // 获得符合匹配条件的ApiVersionCondition
            int version = Integer.valueOf(m.group(1));
            if (version >= getVersion()) {
                return this;
            }
        }
        return null;
    }

    //不同筛选条件比较,用于排序
    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        //return 0;
        // 优先匹配最新的版本号
        // 当出现多个符合匹配条件的ApiVersionCondition，优先匹配版本号较大的
        return apiVersionCondition.getVersion() - getVersion();
    }

}
