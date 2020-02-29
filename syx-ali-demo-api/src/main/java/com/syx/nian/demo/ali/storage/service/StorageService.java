package com.syx.nian.demo.ali.storage.service;



public interface StorageService {
    //减库存
    Integer deduct(String commodityCode, int count);
}
