package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.TeamMember;
import cn.edu.sicnu.service.TeamMemberService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 团队成员(TeamMember)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:41
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TeamMemberController {
    /**
     * 服务对象
     */
    @Resource
    private TeamMemberService teamMemberService;

    @Autowired
    private UserService userService;

    @Autowired
    private Message message;

    /**
     * 查询对应团队id下的团队的所有成员
     *
     * @return data中放入团队成员列表
     */
    @PostMapping("/teamMember/{teamId}")
    public Message findAll(@PathVariable("teamId") String teamId) {
        TeamMember teamMember = new TeamMember();
        teamMember.setTeamId(teamId);
        List<TeamMember> teamMemberList = this.teamMemberService.queryAll(teamMember);
        for (TeamMember member : teamMemberList) {
            member.setUserName(userService.queryById(member.getUserId()).getName());
        }
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(teamMemberList);

        return message;
    }

}