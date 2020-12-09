package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.PaperAchievement;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.PaperAchievementService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 论文成果(PaperAchievement)表控制层
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:28
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PaperAchievementController {
    /**
     * 服务对象
     */
    @Resource
    private PaperAchievementService paperAchievementService;
    @Resource
    private UserService userService;
    @Resource
    private CollegeService collegeService;

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 通过用户id查询论文成果
     *
     * @return 相关数据
     */
    @GetMapping("/achievements/paper/users/{userId}")
    public Message getByUserId(@PathVariable("userId") String id) {
        List<PaperAchievement> achievementList = paperAchievementService.queryByUserId(id);
        String userName;
        String collegeName;
        for (PaperAchievement achievement : achievementList) {
            userName = userService.queryById(achievement.getUserId()).getName();
            achievement.setUserName(userName);
            collegeName = collegeService.queryById(achievement.getCollegeId()).getName();
            achievement.setCollegeName(collegeName);
        }
        return Message.success(achievementList);
    }

    /**
     * 根据成果id号得到成果
     *
     * @param achievementId 成果id号
     * @return 根据id得到的成果实体类
     */
    @GetMapping("/achievements/paper/{achievementId}")
    public Message getByAchievementId(@PathVariable("achievementId") String achievementId) {
        PaperAchievement achievement = paperAchievementService.queryById(achievementId);
        achievement.setUserName(userService.queryById(achievement.getUserId()).getName());
        achievement.setCollegeName(collegeService.queryById(achievement.getCollegeId()).getName());
        return Message.success(achievement);
    }

    /**
     * 查询所有论文成果
     *
     * @return 论文成果列表
     */
    @GetMapping("/achievements/paper")
    public Message getAll() {
        List<PaperAchievement> achievementList = paperAchievementService.findAll();
        for (PaperAchievement paperAchievement : achievementList) {
            paperAchievement.setUserName(userService.queryById(paperAchievement.getUserId()).getName());
            paperAchievement.setCollegeName(collegeService.queryById(paperAchievement.getCollegeId()).getName());
        }

        return Message.success(achievementList);
    }

    /**
     * 增加论文成果
     *
     * @param achievement 论文成果对象
     * @return 增加成功返回状态码0，失败返回其他状态码
     */
    @PostMapping("/achievements/paper")
    public Message add(@RequestBody PaperAchievement achievement) {
        boolean insert = paperAchievementService.insert(achievement);
        if (insert) {
            operLogger.info("新建论文成果成功");
            return Message.success();
        } else {
            operLogger.info("新建论文成果失败");
            return Message.fail();
        }
    }

    /**
     * 修改论文成果
     *
     * @param paperAchievement 论文成果对象
     * @return 修改成功返回状态码0，失败返回其他状态码
     */
    @PutMapping("/achievements/paper")
    public Message update(@RequestBody PaperAchievement paperAchievement) {
        boolean insert = paperAchievementService.update(paperAchievement);
        if (insert) {
            operLogger.info("修改论文成果成功");
            return Message.success();
        } else {
            operLogger.info("修改论文成果失败");
            return Message.fail();
        }
    }

}