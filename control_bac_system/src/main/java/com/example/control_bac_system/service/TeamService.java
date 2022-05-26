package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.vo.Team;

public interface TeamService {
    PageQueryVo<Team> selectTeamList(PageQuery pageQuery);

    Integer addTeam(Team team);

    Integer updateTeam(Team team);
}
