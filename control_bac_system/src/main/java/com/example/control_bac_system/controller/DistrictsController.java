package com.example.control_bac_system.controller;

import com.example.control_bac_system.entity.Districts;
import com.example.control_bac_system.model.ResultModel;
import com.example.control_bac_system.service.DistrictsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("districts")
public class DistrictsController {

    @Resource
    private DistrictsService districtsService;

    @RequestMapping("province")
    public String getProvince(){
        List<Districts> districts = districtsService.selectProvince();
        String success = ResultModel.SUCCESS("200", "查询成功", districts);
        return success;
    }

    @RequestMapping("city")
    public String getCity(@RequestBody Districts districts){
        List<Districts> districts1 = districtsService.selectCity(districts);
        String success = ResultModel.SUCCESS("200", "查询成功", districts1);
        return success;
    }

    @RequestMapping("county")
    public String getCounty(@RequestBody Districts districts){
        List<Districts> districts1 = districtsService.selectCounty(districts);
        String success = ResultModel.SUCCESS("200", "查询成功", districts1);
        return success;
    }
}
