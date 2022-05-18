package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.Districts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DistrictsMapper {


    List<Districts> selectProvince();
    List<Districts> selectCity(@Param("districts") Districts districts);
    List<Districts> selectCounty(@Param("districts") Districts districts);
}
