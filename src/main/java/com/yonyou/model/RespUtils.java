package com.yonyou.model;

public class RespUtils {

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = -1;
    public static final int CODE_ERROR = -99;
    public static final int CODE_ERROR_LOGIN = -101;
    public static final String MSG_SUCCESS = "success";
    public static final int DEFAULT_PAGE_SIZE = 20;

    public RespUtils() {
    }

    public static Resp success(Object data) {
        return new Resp(data);
    }

    public static Resp success(Object data, String msg) {
        return (new Resp(data)).setMsg(msg);
    }

    public static Resp success(Object data, String msg, Long no) {
        return (new Resp(data)).setMsg(msg).setNo(no);
    }

    public static Resp fail(Object data, String msg) {
        return (new Resp(data)).setCode(-1).setMsg(msg);
    }

    public static Resp fail(int code, Object data, String msg) {
        return (new Resp(data)).setCode(code).setMsg(msg);
    }

    public static Resp fail(int code, Object data, String msg, Long no) {
        return (new Resp(data)).setCode(code).setMsg(msg).setNo(no);
    }

    public static Resp error(Object data, String msg) {
        return (new Resp(data)).setCode(-99).setMsg(msg);
    }

    public static Resp error(Object data, String msg, Long no) {
        return (new Resp(data)).setCode(-99).setMsg(msg).setNo(no);
    }

}
