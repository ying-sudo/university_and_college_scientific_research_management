package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.PatentAchievement;
import cn.edu.sicnu.service.PatentAchievementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (PatentAchievement)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:29
 */
@RestController
@RequestMapping("patentAchievement")
public class PatentAchievementController {
    /**
     * 服务对象
     */
    @Resource
    private PatentAchievementService patentAchievementService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PatentAchievement selectOne(String id) {
        return this.patentAchievementService.queryById(id);
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