package com.yonyou.interpreter.common.expression;

/**
 * 抽象的表达式类
 *
 * @author hlz
 * @date 2020年 10月14日 11:12:55
 */
public abstract class AbstractExpression implements IExpression{



    protected abstract Object getVal(ExpressionContext context);

    public abstract String evaluate(ExpressionContext context);

    protected String expVal;
    protected IExpression left;
    protected IExpression right;

}
