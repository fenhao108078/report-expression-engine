package com.yonyou.interpreter.common.expression;

import com.yonyou.interpreter.constant.ExpectTypeEnum;

/**
 * 抽象的终结符表达式
 *
 * @author hlz
 * @date 2020年 10月14日 11:16:16
 */
public abstract class TerminalExpression extends AbstractExpression{

    /**
     * 用于嵌套的表达式
     */
    protected TerminalExpression next;

    /**
     * 值类型
     */
    protected ExpectTypeEnum type;

    /**
     * 值
     */
    protected Object val;
}
