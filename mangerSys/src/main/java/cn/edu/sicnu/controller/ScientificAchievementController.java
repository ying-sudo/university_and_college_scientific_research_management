package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.PaperAchievement;
import cn.edu.sicnu.entity.ScientificAchievement;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.ScientificAchievementService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科研成果(ScientificAchievement)表控制层
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:32
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ScientificAchievementController {
    /**
     * 服务对象
     */
    @Resource
    private ScientificAchievementService scientificAchievementService;

    @Autowired
    private UserService userService;

    @Autowired
    private CollegeService collegeService;

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 通过该用户id，查询该用户的所有科研成果
     *
     * @return 所有数据
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/scientifics')")
    @GetMapping("/achievements/scientific/users/{userId}")
    public Message getByUserId(@PathVariable("userId") String userId) {
        ScientificAchievement achievement = new ScientificAchievement();
        achievement.setUserId(userId);
        List<ScientificAchievement> achievementList = scientificAchievementService.queryAll(achievement);

        String userName = userService.queryById(userId).getName();
        for (ScientificAchievement i : achievementList) {
            i.setUserName(userName);
            String collegeName = collegeService.queryById(i.getCollegeId()).getName();
            i.setCollegeName(collegeName);
        }

        return Message.success(achievementList);
    }

    /**
     * 根据成果id得到成果
     *
     * @param achievementId 成果id号
     * @return 如果存在返回对于科研成果对象，不存在message中data为null
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/scientifics')")
    @GetMapping("/achievements/scientific/{achievementId}")
    public Message getByAchievementId(@PathVariable("achievementId") String achievementId) {
        ScientificAchievement scientificAchievement = scientificAchievementService.queryById(achievementId);
        String userName = userService.queryById(scientificAchievement.getUserId()).getName();
        scientificAchievement.setUserName(userName);
        String collegeName = collegeService.queryById(scientificAchievement.getCollegeId()).getName();
        scientificAchievement.setCollegeName(collegeName);
        return Message.success(scientificAchievement);
    }

    /**
     * 查询所有科研成果
     *
     * @return 所有科研成果
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/scientifics')")
    @GetMapping("/achievements/scientific")
    public Message getAll() {
        List<ScientificAchievement> achievementList = scientificAchievementService.findAll();
        String userName;
        String collegeName;
        for (ScientificAchievement achievement : achievementList) {
            userName = userService.queryById(achievement.getUserId()).getName();
            achievement.setUserName(userName);
            collegeName = collegeService.queryById(achievement.getCollegeId()).getName();
            achievement.setCollegeName(collegeName);
        }
        return Message.success(achievementList);
    }

    /**
     * 新增科研成果
     *
     * @param achievement 传入的科研成果对象
     * @return 修改成功返回状态码为0，失败返回其他状态码
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/scientifics')")
    @PostMapping("/achievements/scientific")
    public Message add(@RequestBody ScientificAchievement achievement) {
        boolean insert = scientificAchievementService.insert(achievement);
        if (insert) {
            operLogger.info("新增科研成果成功");
            return Message.success(null);
        } else {
            operLogger.info("新增科研成果失败");
            return Message.fail(null);
        }
    }

    /**
     * 修改科研成果
     *
     * @param achievement 科研成果对象
     * @return 修改成功返回状态码0，失败返回其他状态码
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/scientifics')")
    @PutMapping("/achievements/scientific")
    public Message update(@RequestBody ScientificAchievement achievement) {
        boolean insert = scientificAchievementService.update(achievement);
        if (insert) {
            operLogger.info("修改论文成果成功");
            return Message.success();
        } else {
            operLogger.info("修改论文成果失败");
            return Message.fail();
        }
    }

}