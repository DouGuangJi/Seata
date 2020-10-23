package com.riest.controller;

import com.riest.service.StorageService;
import com.riest.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class StorageController {


    @Autowired
    private StorageService storageService;


    /**storageService
     *
     * @param productId
     * @param count
     * @return
     */
    @GetMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
