package com.yonyou.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Resp implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long no = System.currentTimeMillis();
    private int code = 0;
    private String msg = "success";
    private Object data = null;
    private final Map<String, Object> attr = new HashMap();

    public Resp() {
    }

    public Resp(Object data) {
        this.data = data;
    }

    public boolean success() {
        return this.code == 0;
    }

    public Long getNo() {
        return this.no;
    }

    public Resp setNo(Long no) {
        this.no = no;
        return this;
    }

    public int getCode() {
        return this.code;
    }

    public Resp setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public Resp setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public Resp setData(Object data) {
        this.data = data;
        return this;
    }

    public Map<String, Object> getAttr() {
        return this.attr;
    }

    public Resp addAttr(String key, Object value) {
        if (value != null) {
            this.attr.put(key, value);
        }

        return this;
    }

    public Object getAttr(String key) {
        return this.attr.get(key);
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("no", this.getNo());
        json.put("code", this.getCode());
        json.put("msg", this.getMsg());
        json.put("data", this.getData());
        Iterator var3 = this.getAttr().entrySet().iterator();

        while (var3.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) var3.next();
            if (entry.getValue() != null) {
                json.put((String) entry.getKey(), entry.getValue());
            }
        }

        return json;
    }

    public String toString() {
        return "[no=" + this.no + "][code=" + this.code + "][msg=" + this.msg + "][data=" + this.data + "][attr=" + this.attr + "]";
    }
}
