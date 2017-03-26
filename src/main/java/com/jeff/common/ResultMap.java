package com.jeff.common;

import java.util.HashMap;

/**
 * Created by zuxing.hezuxing on 2016/6/2.
 */
public class ResultMap extends HashMap<String, Object> {

    public ResultMap() {

    }

    public ResultMap isRedirect(boolean isRedirect) {
        this.put("isRedirect", isRedirect);
        return this;
    }

    public ResultMap url(String url) {
        this.put("url", url);
        return this;
    }

    public ResultMap success() {
        this.put("success", true);
        return this;
    }

    public ResultMap fail() {
        this.put("success", false);
        return this;
    }

    public ResultMap info(String info) {
        this.put("info", info);
        return this;
    }

    public ResultMap msg(String msg) {
        this.put("message", msg);
        return this;
    }

    public ResultMap data(Object data) {
        this.put("data", data);
        return this;
    }

    public ResultMap page(VuePager page) {
        this.put("page", page);
        return this;
    }

}
