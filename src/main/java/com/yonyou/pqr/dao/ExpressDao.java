package com.yonyou.pqr.dao;

import com.yonyou.interpreter.common.expression.bean.CustomExpDO;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressDao {
    void insertExpress(CustomExpDO express);
}
