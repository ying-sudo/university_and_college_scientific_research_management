package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.AchievementMagazine;
import cn.edu.sicnu.entity.Magazine;
import cn.edu.sicnu.service.AchievementMagazineService;
import cn.edu.sicnu.service.MagazineService;
import cn.edu.sicnu.utils.Message;
import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Magazine)期刊表控制层
 * 包括查询所有期刊，查询某个项目或者成果(论文，科研，专利，著作)的期刊收录情况
 * 为某个项目或者成果添加期刊收录
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
    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 查询所有期刊
     *
     * @return 所有数据
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/papers')")
    @GetMapping("/magazine")
    public Message findAll() {
        List<Magazine> magazineList = magazineService.findAll();
        return Message.success(magazineList);
    }

    /**
     * 查询某个项目或者成果(论文，科研，专利，著作)的期刊收录情况
     *
     * @param achievementId 成果或者项目id
     * @return 所有数据
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/papers')")
    @GetMapping("/magazine/{achievementId}")
    public Message findByAchievementId(@PathVariable("achievementId") String achievementId) {
        AchievementMagazine achievementMagazine = achievementMagazineService.queryById(achievementId);
        return Message.success(achievementMagazine);
    }

    /**
     * 为某个项目或者成果增加期刊收录
     *
     * @param achievementMagazine 对应期刊收录情况实体类
     * @return 插入成功返回true，失败返回false
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/papers')")
    @PostMapping("/magazine")
    public Message insert(@RequestBody AchievementMagazine achievementMagazine) {
        System.out.println("achievementMagazine = " + achievementMagazine.toString());
        boolean insert = achievementMagazineService.insert(achievementMagazine);
        if (insert) {
            operLogger.info("插入期刊收录情况成功");
            return Message.success();
        } else {
            operLogger.info("插入期刊收录情况失败");
            return Message.fail();
        }
    }
    @PreAuthorize("hasAnyAuthority('/achievements','/table/papers')")
    @PutMapping("/magazine")
    public Message update(@RequestBody AchievementMagazine achievementMagazine) {
        boolean update = achievementMagazineService.update(achievementMagazine);
        if (update) {
            operLogger.info("修改期刊收录情况成功");
            return Message.success();
        } else {
            operLogger.info("修改期刊收录情况失败");
            return Message.fail();
        }
    }

}