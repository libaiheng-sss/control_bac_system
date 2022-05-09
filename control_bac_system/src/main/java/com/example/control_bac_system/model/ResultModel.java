package com.example.control_bac_system.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class ResultModel {

    private String code;
    private String message;
    private String data;

    public static String Error(String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","500");
        jsonObject.put("message",message);
        return jsonObject.toJSONString();
    }
}
