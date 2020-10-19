package com.yonyou.interpreter.common.symbol;

/**
 * 符号：
 * 在表达式中约定的关键字，符号分非终结符号和包含符号
 * 包含符号用于区分内容，非终结符号用于内容之间的计算
 * 包含符号应有   开始标记和结束标记，开始标记pmt和结束pmt，括号中期望的type
 * 非终结符号中应约定    标记，标记pmt，左边表达式期望类型和右表达式期望类型
 * @author hlz
 */
public interface ISymbol {
}
