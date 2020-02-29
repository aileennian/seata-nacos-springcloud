package com.syx.nian.demo.ali.storage.feign;


import com.syx.nian.demo.ali.core.apiversion.ApiVersion;
import com.syx.nian.demo.ali.core.constant.ServerContant;
import com.syx.nian.demo.ali.core.util.R;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口由提供者实现
 */

@FeignClient(value = ServerContant.PROVIDER_STORAGE)
@Headers({"Accept: application/json", "Content-Type: application/json"})
@RequestMapping("/api/storage/")
public interface StorageApi {


    /**
     * 测试，helloworld
     * @return 员工模型列表
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public R<String> hello();


    /**
     * 查询所有员工
     * @return 员工模型列表
     */
    @RequestMapping(value = "deduct/", method = RequestMethod.GET)
    public R<String> deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}
