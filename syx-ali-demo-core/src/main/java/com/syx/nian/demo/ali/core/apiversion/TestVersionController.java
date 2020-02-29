package com.syx.nian.demo.ali.core.apiversion;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiVersion(1)
@RestController
@RequestMapping("echo/api/{version}/hello")
public class TestVersionController {
    /**
     * http://Ip:port/api/v1/hello
     * @param version
     * @return
     */
    @GetMapping
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
    @GetMapping
    @ApiVersion(2)
    public String test02(@PathVariable String version) {
        return "方法上定义版本号: " + version;
    }
}
