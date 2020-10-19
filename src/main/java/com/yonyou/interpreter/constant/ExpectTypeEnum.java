package com.yonyou.interpreter.constant;

/**
 * 期望的值类型枚举
 *
 * @author hlz
 * @date 2020年 10月03日 09:19:30
 */
public enum ExpectTypeEnum {
    DEFAULT("默认类型"),
    STRING("字符串类型"),
    INT("整数类型"),
    LONG("长整数类型"),
    DOUBLE("浮点数类型"),
    DECIMAL("decimal类型"),
    DATE("日期类型"),
    NUMBER("数字类型");
    public String desc;
    ExpectTypeEnum(String desc){this.desc = desc;}
}
