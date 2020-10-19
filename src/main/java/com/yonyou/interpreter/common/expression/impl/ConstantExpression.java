package com.yonyou.interpreter.common.expression.impl;

import com.yonyou.interpreter.common.expression.ExpressionContext;
import com.yonyou.interpreter.common.expression.TerminalExpression;

/**
 * 常量表达式
 * 最基础表达式
 *
 * @author hlz
 * @date 2020年 10月14日 13:53:21
 */
public class ConstantExpression extends TerminalExpression {
    @Override
    protected Object getVal(ExpressionContext context) {
        return null;
    }

    @Override
    public String evaluate(ExpressionContext context) {
        return null;
    }
}
