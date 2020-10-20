package com.yonyou.interpreter.custom;

import com.yonyou.interpreter.common.expression.ExpressionContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 自定义的代理类
 *
 * @author liet.start
 * @date 2020年 10月19日 18:05:11
 */
public class CustomExpressionProxy implements InvocationHandler {

    private final ICustomHandler exp;

    public CustomExpressionProxy(ICustomHandler exp) {
        this.exp = exp;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //参数转换
        ExpressionContext context = (ExpressionContext)args[0];

        //线程执行控制
        method.invoke(exp,args) ;
        return null;
    }

}
