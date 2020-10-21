package com.yonyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * init
 *
 * @author liet.start
 * @date 2020年 10月19日 15:58:14
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.yonyou.pqr.**.dao"})
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class,args);
    }
}
