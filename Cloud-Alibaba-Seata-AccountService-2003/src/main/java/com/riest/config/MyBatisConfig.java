package com.riest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:MyBatisConfig
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:40
 */
@Configuration
@MapperScan({"com.riest.dao"})
public class MyBatisConfig {
}
