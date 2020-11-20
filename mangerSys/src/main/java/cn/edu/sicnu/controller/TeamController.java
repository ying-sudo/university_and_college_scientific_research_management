package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Team;
import cn.edu.sicnu.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Team)表控制层
 *
 * @author makejava
 * @since 2020-11-19 23:25:41
 */
@RestController
@RequestMapping("team")
public class TeamController {
    /**
     * 服务对象
     */
    @Resource
    private TeamService teamService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Team selectOne(String id) {
        return this.teamService.queryById(id);
    }

    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @RequestMapping("")
    public String findAll() {
        return "";
    }

}