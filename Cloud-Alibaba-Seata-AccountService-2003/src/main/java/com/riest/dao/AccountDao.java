package com.riest.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * ClassName:OrderDao
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:25
 */
@Mapper
public interface AccountDao  {


    /**
     *  扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
