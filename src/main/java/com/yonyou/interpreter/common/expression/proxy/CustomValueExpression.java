package com.yonyou.interpreter.common.expression.proxy;

import com.yonyou.interpreter.common.expression.ExpressionContext;
import com.yonyou.interpreter.common.expression.TerminalExpression;

/**
 * 自定义表达式
 *
 * @author hlz
 * @date 2020年 10月19日 11:42:06
 */
public class CustomValueExpression extends TerminalExpression implements ICustomExpression {
    @Override
    protected Object getVal(ExpressionContext context) {
        return null;
    }

    @Override
    public String evaluate(ExpressionContext context) {
        return null;
    }


}
