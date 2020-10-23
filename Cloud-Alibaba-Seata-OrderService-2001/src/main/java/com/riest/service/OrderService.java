package com.riest.service;

import com.riest.dao.OrderDao;
import com.riest.modal.Order;
import com.riest.service.serviceinterface.AccountService;
import com.riest.service.serviceinterface.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
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
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 切记,第一次启动将该注解注释调
     */
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order){
        log.info("----->开始新建订单");
        //新建订单,调用本服务接口
        orderDao.create(order);

        //扣减库存,通过openFeign远程调用库存服务
        log.error("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.error("----->订单微服务开始调用库存，做扣减end");

        //扣减账户。通过openFeign远程调用账户服务
        log.error("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.error("----->订单微服务开始调用账户，做扣减end");



        //修改订单状态，从零到1代表已经完成,调用本服务
        log.error("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.error("----->修改订单状态结束");

        log.info("----->下订单结束了");
    }
}
