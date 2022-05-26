package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.vo.Team;
import com.example.control_bac_system.mapper.TeamMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Resource
    private TeamMapper teamMapper;

    @Override
    public PageQueryVo<Team> selectTeamList(PageQuery pageQuery) {

        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = teamMapper.selectTeamsTolal(pageQuery);
        if (start >= total && total >= limit && total != 0){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<Team> userInfos = teamMapper.selectTeamsPage(pageQuery);
        PageQueryVo<Team> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(userInfos);
        pageQueryVo.setCurrentPage(currentPage);

        return pageQueryVo;
    }

    @Override
    public Integer addTeam(Team team) {
        Integer i = teamMapper.insertTeam(team);
        return i;
    }

    @Override
    public Integer updateTeam(Team team) {
        Integer i = teamMapper.updateTeam(team);
        return i;
    }
}
