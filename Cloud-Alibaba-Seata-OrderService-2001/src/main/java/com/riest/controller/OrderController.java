package com.riest.controller;

import com.riest.modal.Order;
import com.riest.service.OrderService;
import com.riest.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:OrderController
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:38
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;


    @GetMapping(value = "/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
