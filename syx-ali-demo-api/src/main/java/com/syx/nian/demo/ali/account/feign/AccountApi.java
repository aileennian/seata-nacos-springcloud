package com.syx.nian.demo.ali.account.feign;


import com.syx.nian.demo.ali.core.apiversion.ApiVersion;
import com.syx.nian.demo.ali.core.constant.ServerContant;
import com.syx.nian.demo.ali.core.model.vo.DebitVo;
import com.syx.nian.demo.ali.core.util.R;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 接口由提供者实现
 */
@FeignClient(value = ServerContant.PROVIDER_ACCOUNT)
@Headers({"Accept: application/json", "Content-Type: application/json"})
@RequestMapping("/api/account")
public interface AccountApi {
    /**
     * 查询所有员工
     * @return 员工模型列表
     */
    @RequestMapping(value = "/debit/", method = RequestMethod.POST)
    R<Integer> debit(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);


    /**
     * 查询所有员工
     * @return 员工模型列表
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    R<String> home();






}
