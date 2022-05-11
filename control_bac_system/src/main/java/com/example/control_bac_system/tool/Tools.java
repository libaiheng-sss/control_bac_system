package com.example.control_bac_system.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.control_bac_system.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Tools {

    // 将List<Object>转换成json
    public static String listToJsonStr(List<Object> list){
        String jsonStr = JSONObject.toJSON(list).toString();
        return jsonStr;
    }

    public static void main(String[] args) {
        String phoneNumber = "15213317526";
        String substring = phoneNumber.substring(5, 11);
        System.out.println(substring);
    }
}
