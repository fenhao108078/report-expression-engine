package com.yonyou.pqr.service.impl;

import com.yonyou.interpreter.common.expression.bean.CustomExpDO;
import com.yonyou.pqr.dao.ExpressDao;
import com.yonyou.pqr.service.IExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressService implements IExpressService {

    @Autowired
    ExpressDao expressDao;

    public void insertExpress(CustomExpDO express) {
        expressDao.insertExpress(express);
    }

}
