package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.AchievementMagazine;
import cn.edu.sicnu.service.AchievementMagazineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (AchievementMagazine)表控制层
 *
 * @author makejava
 * @since 2020-11-19 23:25:27
 */
@RestController
@RequestMapping("achievementMagazine")
public class AchievementMagazineController {
    /**
     * 服务对象
     */
    @Resource
    private AchievementMagazineService achievementMagazineService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AchievementMagazine selectOne(String id) {
        return this.achievementMagazineService.queryById(id);
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