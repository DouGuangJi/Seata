package com.riest.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:OrderDao
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:25
 */
@Mapper
public interface StorageDao {

    /**扣减库存信息
     *
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
