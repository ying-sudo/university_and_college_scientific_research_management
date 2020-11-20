package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.PaperAchievement;
import cn.edu.sicnu.service.PaperAchievementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (PaperAchievement)表控制层
 *
 * @author makejava
 * @since 2020-11-19 23:25:33
 */
@RestController
@RequestMapping("paperAchievement")
public class PaperAchievementController {
    /**
     * 服务对象
     */
    @Resource
    private PaperAchievementService paperAchievementService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PaperAchievement selectOne(String id) {
        return this.paperAchievementService.queryById(id);
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