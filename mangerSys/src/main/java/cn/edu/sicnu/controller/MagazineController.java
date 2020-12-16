package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.AchievementMagazine;
import cn.edu.sicnu.entity.Magazine;
import cn.edu.sicnu.service.AchievementMagazineService;
import cn.edu.sicnu.service.MagazineService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Magazine)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:27
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MagazineController {
    /**
     * 服务对象
     */
    @Resource
    private MagazineService magazineService;
    @Autowired
    private AchievementMagazineService achievementMagazineService;

    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("/magazine/{achievementId}")
    public Message findAll(@PathVariable("achievementId") String achievementId) {
        List<Magazine> magazineList = magazineService.findAll();
        AchievementMagazine achievementMagazine = achievementMagazineService.queryById(achievementId);
        Map<String, Object> map = new HashMap<>();
        map.put("magazineSort", magazineList);
        map.put("magazineId", achievementMagazine);
        return Message.success(map);
    }

}