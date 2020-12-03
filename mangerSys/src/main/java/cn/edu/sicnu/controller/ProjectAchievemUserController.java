package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.ProjectAchievemUser;
import cn.edu.sicnu.service.ProjectAchievemUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (ProjectAchievemUser)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:31
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("projectAchievemUser")
public class ProjectAchievemUserController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectAchievemUserService projectAchievemUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectAchievemUser selectOne(String id) {
        return this.projectAchievemUserService.queryById(id);
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