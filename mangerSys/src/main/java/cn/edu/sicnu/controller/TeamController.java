package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Team;
import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.service.TeamService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
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

    @Autowired
    private UserService userService;

    @Autowired
    private Message message;

    /**
     * 通过用户id查找这个用户为负责人的团队
     *
     * @param userId 用户id
     * @return 团队列表
     */
    @PostMapping("/team/{userId}")
    public Message selectOne(@PathVariable("userId") String userId) throws IOException {
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        Team team = new Team();
        team.setUserId(userId);

        List<Team> teamList = teamService.queryAll(team);

        Users user = userService.queryById(userId);
        for (Team eachTeam : teamList) {
            eachTeam.setUserName(user.getName());
        }

        message.setData(teamList);
        return message;
    }



}