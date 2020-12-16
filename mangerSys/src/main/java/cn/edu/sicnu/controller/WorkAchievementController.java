package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.WorkAchievement;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.service.WorkAchievementService;
import cn.edu.sicnu.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WorkAchievement)著作成果表控制层
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:43
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class WorkAchievementController {
    /**
     * 服务对象
     */
    @Resource
    private WorkAchievementService workAchievementService;
    @Resource
    private UserService userService;
    @Resource
    private CollegeService collegeService;

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 查询用户的著作成果，根据用户id
     *
     * @param userId 用户id
     * @return 该用户所有著作成果
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/works')")
    @GetMapping("/achievements/work/users/{userId}")
    public Message getByUserId(@PathVariable("userId") String userId) {
        List<WorkAchievement> workAchievements = workAchievementService.queryByUserId(userId);
        String userName;
        String collegeName;
        for (WorkAchievement achievement : workAchievements) {
            userName = userService.queryById(achievement.getUserId()).getName();
            achievement.setUserName(userName);
            collegeName = collegeService.queryById(achievement.getCollegeId()).getName();
            achievement.setCollegeName(collegeName);
        }
        return Message.success(workAchievements);
    }

    /**
     * 根据成果id查询著作成果
     *
     * @param achievementId 著作成果id
     * @return 存在对应id的著作成果对象返回成功，状态码为0,
     * 如果没有这个id的记录则返回其他状态码，且message中data未空
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/works')")
    @GetMapping("/achievements/work/{achievementId}")
    public Message getByAchievementId(@PathVariable("achievementId") String achievementId) {
        WorkAchievement achievement = workAchievementService.queryById(achievementId);
        String userName = userService.queryById(achievement.getUserId()).getName();
        achievement.setUserName(userName);
        String collegeName = collegeService.queryById(achievement.getCollegeId()).getName();
        achievement.setCollegeName(collegeName);
        return Message.success(achievement);
    }

    /**
     * 查询所有著作成果
     *
     * @return 所有著作成果的列表
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/works')")
    @GetMapping("/achievements/work")
    public Message getAll() {
        List<WorkAchievement> achievementList = workAchievementService.findAll();
        String userName;
        String collegeName;
        for (WorkAchievement achievement : achievementList) {
            userName = userService.queryById(achievement.getUserId()).getName();
            achievement.setUserName(userName);
            collegeName = collegeService.queryById(achievement.getCollegeId()).getName();
            achievement.setCollegeName(collegeName);
        }
        return Message.success(achievementList);
    }

    /**
     * 新增著作成果
     *
     * @param workAchievement 著作成果对象
     * @return 成功返回状态码为0
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/works')")
    @PostMapping("/achievements/work")
    public Message add(@RequestBody WorkAchievement workAchievement) {
        boolean insert = workAchievementService.insert(workAchievement);
        if (insert) {
            operLogger.info("新增著作成果成功");
            return Message.success();
        } else {
            operLogger.info("新增著作成果失败");
            return Message.fail();
        }
    }

    /**
     * 修改著作成果
     *
     * @param workAchievement 著作成果实体类
     * @return 修改成功状态码为0，其他为修改失败
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/works')")
    @PutMapping("/achievements/work")
    public Message update(@RequestBody WorkAchievement workAchievement) {
        boolean update = workAchievementService.update(workAchievement);
        if (update) {
            operLogger.info("修改著作成果成功");
            return Message.success();
        } else {
            operLogger.info("修改著作成果失败");
            return Message.fail();
        }
    }
}