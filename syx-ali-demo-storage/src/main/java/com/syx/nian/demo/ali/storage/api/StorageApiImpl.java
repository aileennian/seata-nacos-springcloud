package com.syx.nian.demo.ali.storage.api;

import com.syx.nian.demo.ali.core.util.R;
import com.syx.nian.demo.ali.storage.feign.StorageApi;
import com.syx.nian.demo.ali.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageApiImpl implements StorageApi {
   // @Autowired
    private final StorageService storageService;

    @Autowired
    public StorageApiImpl(StorageService storageService) {
        this.storageService = storageService;
    }


    @Override
    public R<String> hello() {
        return R.OK("欢迎使用新版的API接口");
    }


    @Override
    public R<String> deduct(String commodityCode, Integer count) {
        Integer i = storageService.deduct(commodityCode,count);
        return R.OK("{'id':'"+ i +"'}");
    }
}
