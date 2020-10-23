package com.riest.service.serviceinterface;

import com.riest.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:StorageService
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:34
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService{
    /**
     *
     * @param productId
     * @param count
     * @return
     */
    @GetMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
