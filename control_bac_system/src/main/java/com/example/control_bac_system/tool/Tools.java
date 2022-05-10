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
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setEmail("123");
        userInfo.setUsername("amdin");
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2);
        userInfo2.setEmail("热无法");
        userInfo2.setUsername("水电费水电费");
        List<UserInfo>  userInfoList = new ArrayList<>();
        userInfoList.add(userInfo);
        userInfoList.add(userInfo2);
        String s = listToJsonStr(Collections.singletonList(userInfoList));
        System.out.println(s);
    }
}
