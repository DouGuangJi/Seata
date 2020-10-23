package com.riest.service;

import com.riest.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


/**
 * ClassName:OrderService
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:29
 */
@Service
@Slf4j
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Resource
     private AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    public void decrease(Long userId, BigDecimal money) {

        LOGGER.error("------->account-service中扣减账户余额开始");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId,money);
        LOGGER.error("------->account-service中扣减账户余额结束");
    }


}
