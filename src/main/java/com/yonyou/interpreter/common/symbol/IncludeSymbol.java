package com.yonyou.interpreter.common.symbol;

import com.yonyou.interpreter.constant.ExpectTypeEnum;

/**
 * 包含符号
 *
 * @author hlz
 * @date 2020年 10月09日 17:15:26
 */
public class IncludeSymbol extends AbstractSymbol{
    final String _sy;
    final String sy_;
    final int[] _pmt;
    final int[] pmt_;
    final ExpectTypeEnum type;

    public IncludeSymbol(String _sy, String sy_, int[] _pmt, int[] pmt_, ExpectTypeEnum type) {
        this._sy = _sy;
        this.sy_ = sy_;
        this._pmt = _pmt;
        this.pmt_ = pmt_;
        this.type = type;
    }
}
