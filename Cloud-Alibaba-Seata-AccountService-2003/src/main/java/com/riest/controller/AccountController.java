package com.riest.controller;

import com.riest.service.AccountService;
import com.riest.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * ClassName:OrderController
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:38
 */
@RestController
@Slf4j
public class AccountController  {

    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    @GetMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }

}
