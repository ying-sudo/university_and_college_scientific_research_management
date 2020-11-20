package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.TeamMember;
import cn.edu.sicnu.service.TeamMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TeamMember)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:41
 */
@RestController
@RequestMapping("teamMember")
public class TeamMemberController {
    /**
     * 服务对象
     */
    @Resource
    private TeamMemberService teamMemberService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TeamMember selectOne(String id) {
        return this.teamMemberService.queryById(id);
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