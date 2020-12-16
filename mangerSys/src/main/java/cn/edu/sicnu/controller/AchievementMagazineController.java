package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.AchievementMagazine;
import cn.edu.sicnu.service.AchievementMagazineService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (AchievementMagazine)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:22
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AchievementMagazineController {
    /**
     * 服务对象
     */
    @Resource
    private AchievementMagazineService achievementMagazineService;

    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @RequestMapping("/achievementMagazine")
    public String findByAchievementId() {
        return "";
    }

}