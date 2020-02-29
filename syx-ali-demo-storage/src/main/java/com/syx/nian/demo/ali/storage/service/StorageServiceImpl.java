package com.syx.nian.demo.ali.storage.service;


import com.syx.nian.demo.ali.storage.dao.StorageDao;
import com.syx.nian.demo.ali.core.util.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户购买
 */
@Service
public class StorageServiceImpl implements StorageService {

    private final StorageDao storageDao;

    @Autowired
    public StorageServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }


    /**
     * 减库存
     * @param commodityCode
     * @param count
     * @return
     */
    @Override
    public Integer deduct(String commodityCode, int count) {
        int re = storageDao.updateCount(commodityCode,count);
        if (re>0){
            return re;
        }else{
            throw new BusinessException("库存不足！");
        }
    }
}
