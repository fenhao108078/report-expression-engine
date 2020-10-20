package com.yonyou.interpreter.custom;

import com.yonyou.interpreter.common.expression.ExpressionContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理接口
 *
 * @author hlz
 * @date 2020年 10月19日 11:26:23
 */
public interface ICustomHandler {
    public Object execute(Object... args);
}
