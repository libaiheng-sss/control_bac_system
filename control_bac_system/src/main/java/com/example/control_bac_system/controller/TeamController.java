package com.example.control_bac_system.controller;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.vo.Team;
import com.example.control_bac_system.entity.vo.UserInfoVo;
import com.example.control_bac_system.model.ResultModel;
import com.example.control_bac_system.service.TeamService;
import com.example.control_bac_system.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("team")
public class TeamController {

    @Resource
    private UserInfoService userInfoService;
    @Resource
    private TeamService teamService;

    @RequestMapping("getUserList")
    public String getUserList(){
        List<UserInfoVo> userInfoVoList = userInfoService.getAllUser();
        String success = ResultModel.SUCCESS("200", "获取人员列表", userInfoVoList);
        return success;
    }
    
    @RequestMapping("getTeamList")
    public String getTeamList(@RequestBody PageQuery pageQuery){
        PageQueryVo<Team> pageQueryVo = teamService.selectTeamList(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取团队列表", pageQueryVo);
        return success;
    }
    @RequestMapping("add")
    public String addTeam(@RequestBody Team team){
        Integer i = teamService.addTeam(team);
        String success = ResultModel.SUCCESS("200", "添加团队", i);
        return success;
    }

    @RequestMapping("update")
    public String updateTeam(@RequestBody Team team){
        Integer i = teamService.updateTeam(team);
        String success = ResultModel.SUCCESS("200", "修改团队成功", i);
        return success;
    }
}
