package com.riest.service;

import com.riest.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * ClassName:OrderService
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:29
 */
@Service
@Slf4j
public class StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);

    @Resource
    private StorageDao storageDao;


    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("------->storage-service中扣减库存结束");
    }


}
