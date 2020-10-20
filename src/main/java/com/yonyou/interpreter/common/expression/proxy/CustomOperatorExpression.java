package com.yonyou.interpreter.common.expression.proxy;

import com.yonyou.interpreter.common.expression.ExpressionContext;
import com.yonyou.interpreter.common.expression.NonTerminalExpression;

/**
 * 自定义运算符表达式
 *
 * @author hlz
 * @date 2020年 10月19日 11:44:37
 */
public class CustomOperatorExpression extends NonTerminalExpression implements ICustomExpression {
    @Override
    protected Object getVal(ExpressionContext context) {
        return null;
    }

    @Override
    public String evaluate(ExpressionContext context) {
        return null;
    }

}
