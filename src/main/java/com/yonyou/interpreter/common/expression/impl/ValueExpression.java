package com.yonyou.interpreter.common.expression.impl;

import com.yonyou.interpreter.common.expression.ExpressionContext;
import com.yonyou.interpreter.common.expression.TerminalExpression;

/**
 * 值表达式类型
 * 可嵌套的表达式
 *
 * @author hlz
 * @date 2020年 10月14日 11:26:36
 */
public class ValueExpression extends TerminalExpression {


    @Override
    protected Object getVal(ExpressionContext context) {
        return null;
    }

    @Override
    public String evaluate(ExpressionContext context) {
        return null;
    }
}
