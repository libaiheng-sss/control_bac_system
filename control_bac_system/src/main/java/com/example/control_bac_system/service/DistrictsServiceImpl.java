package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Districts;
import com.example.control_bac_system.mapper.DistrictsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DistrictsServiceImpl implements DistrictsService{

    @Resource
    private DistrictsMapper districtsMapper;
    @Override
    public List<Districts> selectProvince() {
        List<Districts> districts = districtsMapper.selectProvince();
        return districts;
    }

    @Override
    public List<Districts> selectCity(Districts districts) {

        List<Districts> districts1 = districtsMapper.selectCity(districts);
        return districts1;
    }

    @Override
    public List<Districts> selectCounty(Districts districts) {
        List<Districts> districts1 = districtsMapper.selectCounty(districts);
        return districts1;
    }
}
