package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Team;
import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.service.TeamMemberService;
import cn.edu.sicnu.service.TeamService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Team)表控制层
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:33
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TeamController {
    /**
     * 服务对象
     */
    @Resource
    private TeamService teamService;

    @Resource
    private TeamMemberService teamMemberService;

    @Autowired
    private UserService userService;

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 通过用户id查找这个用户为负责人的团队
     *
     * @param userId 用户id
     * @return 团队列表
     */
    @GetMapping("/teams/users/{userId}")
    public Message getTeamByUserId(@PathVariable("userId") String userId) {
        Team team = new Team();
        team.setUserId(userId);

        List<Team> teamList = teamService.queryAll(team);
        if (teamList.size() != 0) {
            Users user = userService.queryById(userId);
            for (Team eachTeam : teamList) {
                eachTeam.setUserName(user.getName());
            }
        }
        return Message.success(teamList);
    }

    /**
     * 根据团队id号得到团队信息
     *
     * @param teamId 团队id号
     * @return 如果存在返回团队对象，不存在返回空对象
     */
    @GetMapping("/teams/{teamId}")
    public Message getTeamByTeamId(@PathVariable("teamId") String teamId) {
        Team team = teamService.queryById(teamId);
        if (team != null) {
            team.setUserName(userService.queryById(team.getUserId()).getName());
            return Message.success(team);
        }
        return Message.fail();

    }

    /**
     * 查询所有的团队
     *
     * @return 所有团队对象的list
     */
    @GetMapping("/teams")
    public Message getAllTeam() {
        List<Team> teamList = teamService.findAll();
        String userName;
        for (Team team : teamList) {
            userName = userService.queryById(team.getUserId()).getName();
            team.setUserName(userName);
        }
        return Message.success(teamList);
    }

    /**
     * 新建团队
     *
     * @param team 团队实体类
     * @return 成功返回状态码为0，失败返回其他状态码
     */
    @PostMapping("/teams")
    public Message addTeam(@RequestBody Team team) {
        boolean insert = teamService.insert(team);
        if (insert) {
            operLogger.info("新建团队成功");
            return Message.success();
        } else {
            operLogger.info("新建团队失败");
            return Message.fail();
        }
    }

    /**
     * 修改团队信息，团队id不能变
     *
     * @param team 团队实体类
     * @return 成功返回状态码为0，失败返回其他状态码
     */
    @PutMapping("/teams")
    public Message updateTeam(@RequestBody Team team) {
        boolean update = teamService.update(team);
        if (update) {
            operLogger.info("修改团队成功");
            return Message.success();
        } else {
            operLogger.info("修改团队失败");
            return Message.fail();
        }
    }

    /**
     * 解散团队
     *
     * @param teamId 团队id
     * @return 成功返回状态码为0，失败返回其他状态码
     */
    @DeleteMapping("/teams/{teamId}")
    public Message deleteTeam(@PathVariable("teamId") String teamId) {
        boolean delete = teamService.deleteById(teamId);
        if (delete) {
            operLogger.warn("解散团队成功");
            return Message.success();
        } else {
            operLogger.warn("解散团队失败");
            return Message.fail();
        }
    }

}