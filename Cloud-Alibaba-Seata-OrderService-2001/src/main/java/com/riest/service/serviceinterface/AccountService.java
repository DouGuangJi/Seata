package com.riest.service.serviceinterface;

import com.riest.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * ClassName:AccountService
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:36
 */
@FeignClient(value = "seata-account-service")
public interface AccountService{
    /**
     *
     * @param userId
     * @param money
     * @return
     */
    @GetMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
