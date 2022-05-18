package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Districts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DistrictsService {
    List<Districts> selectProvince();
    List<Districts> selectCity(Districts districts);
    List<Districts> selectCounty(Districts districts);
}
