package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.PatentAchievement;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.PatentAchievementService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 专利(PatentAchievement)表控制层
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:29
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PatentAchievementController {
    /**
     * 服务对象
     */
    @Resource
    private PatentAchievementService patentAchievementService;

    @Autowired
    private UserService userService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private Message message;

    /**
     * 通过用户id查询该用户的所有专利
     *
     * @param userId 用户id
     * @return data中有该用户所有专利的list
     */
    @PostMapping("/patentAchievement/{id}")
    public Message findAll(@PathVariable("id") String userId) {
        PatentAchievement achievement = new PatentAchievement();
        achievement.setUserId(userId);
        List<PatentAchievement> achievementList = patentAchievementService.queryAll(achievement);

//        前端需要用户名和学院名，而不是用户id和学院id
        String userName = userService.queryById(userId).getName();
        for (PatentAchievement i : achievementList) {
            i.setUserName(userName);
            i.setCollegeName(collegeService.queryById(i.getCollegeId()).getName());
        }
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(achievementList);
        return message;
    }

    @PutMapping("/patentAchievement")
    public Message update(@RequestBody PatentAchievement patentAchievement) {
        System.out.println(patentAchievement);
        patentAchievementService.insert(patentAchievement);
        return Message.success(null);
    }

}