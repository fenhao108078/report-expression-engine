package com.yonyou.pqr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test
 *
 * @author liet.start
 * @date 2020年 10月19日 16:04:37
 */
@RestController
public class TestController {
    @GetMapping("test")
    public static String main1() {
        System.out.println("11111");
        return "hello world";
    }
}
