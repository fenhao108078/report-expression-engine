package com.yonyou.interpreter.constant;

import com.yonyou.interpreter.common.symbol.ISymbol;
import com.yonyou.interpreter.common.symbol.IncludeSymbol;
import com.yonyou.interpreter.common.symbol.NonTerminalSymbol;
import com.yonyou.interpreter.util.StringMatchUtils;

/**
 * 符号枚举
 * 用来对表达式进行
 *
 * @author hlz
 * @date 2020年 09月30日 16:41:29
 */
public enum SymbolEnum {
    DEMO,
    EXPRESSION,
    BRACKET,
    REFERENCE,
    STR,
    DATASOURCE,
    ADD,
    ;


    public ISymbol symbol;

    SymbolEnum(String st, String end, ExpectTypeEnum type) {
        int[] _pmt = StringMatchUtils.pmt(st);
        int[] pmt_ = StringMatchUtils.pmt(end);

        this.symbol = new IncludeSymbol(st, end, _pmt, pmt_, type);
    }

    SymbolEnum(String sy, ExpectTypeEnum _t, ExpectTypeEnum t_) {
        int[] pmt = StringMatchUtils.pmt(sy);
        this.symbol = new NonTerminalSymbol(sy, pmt, _t, t_);
    }

    SymbolEnum() {

    }
}
