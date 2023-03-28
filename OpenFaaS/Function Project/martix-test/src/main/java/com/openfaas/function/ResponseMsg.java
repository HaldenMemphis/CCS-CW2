package com.openfaas.function;

/**
 * @program: performance-test-core
 * @description: response message
 * @author: yfliu
 * @create: 2023-03-24 11:21
 **/

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashMap;

public class ResponseMsg extends HashMap<String, Object> implements Serializable {

    public ResponseMsg() {
        super.put("code", 0);
    }

    public static ResponseMsg ok() {
        return new ResponseMsg();
    }

    public static ResponseMsg ok(String msg) {
        return ok(msg, null);
    }

    public static ResponseMsg ok(HashMap<String, Object> map) {
        return ok(null, map);
    }

    public static ResponseMsg ok(String msg, HashMap<String, Object> map) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.put("desc", msg);
        if (map != null) {
            responseMsg.putAll(map);
        }
        return responseMsg;
    }

    public static ResponseMsg ok(JSONObject resultObj) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.put("desc", "success");
        responseMsg.put("msg", resultObj);
        return responseMsg;
    }

    public static ResponseMsg ok(Object returnObject) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.put("msg", returnObject);
        return responseMsg;
    }

    public static ResponseMsg error(int code, String msg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.put("code", code);
        responseMsg.put("desc", msg);
        return responseMsg;
    }

    public static ResponseMsg error(int code, Object msg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.put("code", code);
        responseMsg.put("desc", msg);
        return responseMsg;
    }

    public static ResponseMsg error(String msg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.put("code", null);
        responseMsg.put("desc", msg);
        return responseMsg;
    }

    @Override
    public ResponseMsg put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
