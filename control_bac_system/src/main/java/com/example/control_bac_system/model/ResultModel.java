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

    public static String SUCCESS(String code,String message,Object data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("message",message);
        jsonObject.put("data",data);
        return jsonObject.toJSONString();
    }
}
