package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.entity.vo.Team;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamMapper {
    Integer selectTeamsTolal(PageQuery pageQuery);

    List<Team> selectTeamsPage(PageQuery pageQuery);

    Integer insertTeam(Team team);

    Integer updateTeam(Team team);
}
