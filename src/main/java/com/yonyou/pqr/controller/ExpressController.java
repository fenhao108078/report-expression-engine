package com.yonyou.pqr.controller;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.interpreter.common.expression.bean.CustomExpDO;
import com.yonyou.model.Resp;
import com.yonyou.model.RespUtils;
import com.yonyou.pqr.dao.ExpressDao;
import com.yonyou.pqr.service.IExpressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * test
 *
 * @author dzh
 */
@RestController
public class ExpressController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IExpressService expressService;

    @GetMapping("testExp")
    public Resp testExp() {
        try {
            CustomExpDO exp = new CustomExpDO();
            exp.setId(new Random().nextLong());
            exp.setSetYear(2020);
            exp.setRgCode("87");
            exp.setUserId("1");
            exp.setClazz("你好".getBytes());
            expressService.insertExpress(exp);

            return RespUtils.success(null);
        } catch (Exception e) {
            logger.error("保存模板公式失败", e);
            return RespUtils.error(null, "保存模板公式失败");
        }
    }
}
