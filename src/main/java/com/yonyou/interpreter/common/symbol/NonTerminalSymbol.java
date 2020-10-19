package com.yonyou.interpreter.common.symbol;

import com.yonyou.interpreter.constant.ExpectTypeEnum;

/**
 * 非终结符号
 *
 * @author hlz
 * @date 2020年 10月09日 17:13:36
 */
public class NonTerminalSymbol extends AbstractSymbol{
    String sy;
    int[] pmt;
    ExpectTypeEnum _type;
    ExpectTypeEnum type_;

    public NonTerminalSymbol(String sy, int[] pmt, ExpectTypeEnum _type, ExpectTypeEnum type_) {
        this.sy = sy;
        this.pmt = pmt;
        this._type = _type;
        this.type_ = type_;
    }
}
