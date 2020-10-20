package com.yonyou.interpreter.common.expression.bean;

import java.util.Date;

/**
 * 自定义表达式数据库对象
 *
 * @author liet.start
 * @date 2020年 10月20日 09:13:39
 */
public class CustomExpDO {

    /**
     * 主键
     */
    private long id;

    /**
     * 年度
     */
    private int setYear;

    /**
     * 区划
     */
    private String rgCode;

    /**
     * 单位代码
     */
    private String coCode;

    /**
     * 报表id
     */
    private String reportId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 参数类型（以ExpectTypeEnum中设置为准） 支持64/3=21个参数
     */
    private long argsType;

    /**
     * 参数数量，最大为21
     */
    private int paramNum;

    /**
     * 表达式名
     */
    private String expName;

    /**
     * 表达式代码
     */
    private String expCode;

    /**
     * 表达式类型 0-终结符 1-非终结符
     */
    private int expType;

    /**
     * 标识符
     */
    private String identifier;

    /**
     * 字节码数组
     */
    private byte[] clazz;

    /**
     * 用户输入代码
     */
    private String inputCode;

    /**
     * 编译时间
     */
    private String compileTime;


    private Date createTime;
    private Date modifyTime;
    private String createBy;
    private String modifyBy;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSetYear() {
        return setYear;
    }

    public void setSetYear(int setYear) {
        this.setYear = setYear;
    }

    public String getRgCode() {
        return rgCode;
    }

    public void setRgCode(String rgCode) {
        this.rgCode = rgCode;
    }

    public String getCoCode() {
        return coCode;
    }

    public void setCoCode(String coCode) {
        this.coCode = coCode;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getArgsType() {
        return argsType;
    }

    public void setArgsType(long argsType) {
        this.argsType = argsType;
    }

    public int getParamNum() {
        return paramNum;
    }

    public void setParamNum(int paramNum) {
        this.paramNum = paramNum;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpCode() {
        return expCode;
    }

    public void setExpCode(String expCode) {
        this.expCode = expCode;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public byte[] getClazz() {
        return clazz;
    }

    public void setClazz(byte[] clazz) {
        this.clazz = clazz;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getCompileTime() {
        return compileTime;
    }

    public void setCompileTime(String compileTime) {
        this.compileTime = compileTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public int getExpType() {
        return expType;
    }

    public void setExpType(int expType) {
        this.expType = expType;
    }
}
