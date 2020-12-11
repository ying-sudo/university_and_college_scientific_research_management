package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.TeamMember;
import cn.edu.sicnu.service.TeamMemberService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 查询对应团队id下的团队的所有成员
     *
     * @return data中放入团队成员列表
     */
    @GetMapping("/teams/{teamId}/members")
    public Message getMembersByTeamId(@PathVariable("teamId") String teamId) {
        TeamMember teamMember = new TeamMember();
        teamMember.setTeamId(teamId);
        List<TeamMember> teamMemberList = this.teamMemberService.queryAll(teamMember);
        for (TeamMember member : teamMemberList) {
            member.setUserName(userService.queryById(member.getUserId()).getName());
        }

        return Message.success(teamMemberList);
    }

    /**
     * 查看某团队下的某一个成员的信息
     *
     * @param teamId   团队id
     * @param memberId 成员id（用户id）
     * @return data放入团队下的某一个成员的信息
     */
    @GetMapping("/teams/{teamId}/members/{memberId}")
    public Message getMembersByMemberId(@PathVariable("teamId") String teamId,
                                        @PathVariable("memberId") String memberId) {
        TeamMember teamMember = teamMemberService.queryById(teamId, memberId);
        String userName = userService.queryById(memberId).getName();
        teamMember.setUserName(userName);
        return Message.success(teamMember);
    }

    /**
     * 添加团队成员，可以添加多个
     *
     * @param teamMemberList 团队成员对象的list
     * @return 添加成功返回状态码为0，其他状态码为失败
     */
    @PostMapping("/teams/members")
    public Message addMembers(@RequestBody List<TeamMember> teamMemberList) {
        boolean insert = teamMemberService.insert(teamMemberList);
        if (insert) {
            operLogger.info("添加团队成员成功");
            return Message.success();
        } else {
            operLogger.info("添加团队成员失败");
            return Message.fail();
        }
    }

    /**
     * 修改团队成员信息，支持批量修改
     *
     * @return 修改成功返回true，失败返回false
     */
    @PutMapping("/teams/members")
    public Message updateMembers(@RequestBody TeamMember teamMember) {
        boolean update = teamMemberService.update(teamMember);
        if (update) {
            operLogger.info("修改团队成员信息成功");
            return Message.success();
        } else {
            operLogger.info("修改团队成员信息失败");
            return Message.fail();
        }
    }

    /**
     * 移除团队成员
     *
     * @return 移除成功返回true，失败返回false
     */
    @DeleteMapping("/teams/{teamId}/members/{memberId}")
    public Message deleteMembers(@PathVariable("teamId") String teamId,
                                 @PathVariable("memberId") String userId) {
        boolean delete = teamMemberService.deleteById(teamId, userId);
        if (delete) {
            operLogger.warn("移除团队成员成功");
            return Message.success();
        } else {
            operLogger.warn("移除团队成员失败");
            return Message.fail();
        }
    }

}