package com.riest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:SeataApplication
 * Describe:
 * Author:DGJ
 * Data:2020/10/22 10:18
 */
@EnableDiscoveryClient
@EnableFeignClients
/**
 * 取消数据源自动创建的配置
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication.class, args);
    }
}
