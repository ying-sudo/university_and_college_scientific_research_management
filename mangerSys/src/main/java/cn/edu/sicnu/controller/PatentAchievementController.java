package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.PatentAchievement;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.PatentAchievementService;
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

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 通过用户id查询该用户的所有专利
     *
     * @param userId 用户id
     * @return data中有该用户所有专利的list
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/patents')")
    @GetMapping("/achievements/patent/users/{userId}")
    public Message getByUserId(@PathVariable("userId") String userId) {
        PatentAchievement achievement = new PatentAchievement();
        achievement.setUserId(userId);
        List<PatentAchievement> achievementList = patentAchievementService.queryAll(achievement);

//        前端需要用户名和学院名，而不是用户id和学院id
        String userName = userService.queryById(userId).getName();
        for (PatentAchievement i : achievementList) {
            i.setUserName(userName);
            i.setCollegeName(collegeService.queryById(i.getCollegeId()).getName());
        }
        return Message.success(achievementList);
    }

    /**
     * 通过成果id得到专利
     *
     * @param achievementId 成果id
     * @return 请求成功data中放入成果实体类
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/patents')")
    @GetMapping("/achievements/patent/{achievementId}")
    public Message getByAchievementId(@PathVariable("achievementId") String achievementId) {
        PatentAchievement patentAchievement = patentAchievementService.queryById(achievementId);
        return Message.success(patentAchievement);
    }

    /**
     * 查询所有专利产品
     *
     * @return 所有专利产品的list
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/patents')")
    @GetMapping("/achievements/patent")
    public Message getAll() {
        List<PatentAchievement> achievementList = patentAchievementService.findAll();
        String userName;
        String collegeName;
        for (PatentAchievement achievement : achievementList) {
            userName = userService.queryById(achievement.getUserId()).getName();
            achievement.setUserName(userName);
            collegeName = collegeService.queryById(achievement.getCollegeId()).getName();
            achievement.setCollegeName(collegeName);
        }
        return Message.success(achievementList);
    }

    /**
     * 增加专利产品
     *
     * @param patentAchievement 专利产品实体类
     * @return 增加成功返回状态码0，失败返回其他状态码
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/patents')")
    @PostMapping("/achievements/patent")
    public Message add(@RequestBody PatentAchievement patentAchievement) {
        boolean insert = patentAchievementService.insert(patentAchievement);
        if (insert) {
            operLogger.info("新增专利产品成功");
            return Message.success();
        } else {
            operLogger.info("新增专利产品失败");
            return Message.fail();
        }
    }

    /**
     * 修改专利产品
     *
     * @param patentAchievement 专利产品实体类
     * @return 增加成功返回状态码0，失败返回其他状态码
     */
    @PreAuthorize("hasAnyAuthority('/achievements','/table/patents')")
    @PutMapping("/achievements/patent")
    public Message update(@RequestBody PatentAchievement patentAchievement) {
        boolean update = patentAchievementService.update(patentAchievement);
        if (update) {
            operLogger.info("修改专利产品成功");
            return Message.success();
        } else {
            operLogger.info("修改专利产品失败");
            return Message.fail();
        }
    }
}