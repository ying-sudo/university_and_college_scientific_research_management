package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.WorkAchievement;
import cn.edu.sicnu.service.WorkAchievementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (WorkAchievement)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:43
 */
@RestController
@RequestMapping("workAchievement")
public class WorkAchievementController {
    /**
     * 服务对象
     */
    @Resource
    private WorkAchievementService workAchievementService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WorkAchievement selectOne(String id) {
        return this.workAchievementService.queryById(id);
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