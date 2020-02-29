package com.syx.nian.demo.ali.account.api;

import com.syx.nian.demo.ali.core.apiversion.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ApiVersion(1)
@RequestMapping("/api/{version}/echo")
public class TestVersion {
    @ApiVersion(2)
    @GetMapping("/")
    public String test01(@PathVariable String version) {
        return "test01 : " + version;
    }

    /**
     * http://Ip:port/api/v2/hello
     * http://Ip:port/api/v3/hello
     * http://Ip:port/api/hello？？还没验证
     * 最大版本号原则
     * @param version
     * @return
     */
    @GetMapping("/")
    public String test02(@PathVariable String version) {
        return "方法上定义版本号: " + version;
    }
}