package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.ScientificAchievement;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.ScientificAchievementService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Message message;

    /**
     * 通过该用户id，查询该用户的所有科研成果
     *
     * @return 所有数据
     */
    @PostMapping("/scientAchieve/{id}")
    public Message findAll(@PathVariable("id") String userId) {
        ScientificAchievement achievement = new ScientificAchievement();
        achievement.setUserId(userId);
        List<ScientificAchievement> achievementList = scientificAchievementService.queryAll(achievement);

        String userName = userService.queryById(userId).getName();
        for (ScientificAchievement i : achievementList) {
            i.setUserName(userName);
            String collegeName = collegeService.queryById(i.getCollegeId()).getName();
            i.setCollegeName(collegeName);
        }
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(achievementList);
        return message;
    }

    @PutMapping("/scientAchieve")
    public Message update(@RequestBody ScientificAchievement achievement) {
        System.out.println(achievement);
        scientificAchievementService.insert(achievement);
        return Message.success(null);
    }

}