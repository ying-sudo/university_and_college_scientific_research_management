package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.WorkAchievement;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.service.WorkAchievementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WorkAchievement)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:43
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("workAchievement")
public class WorkAchievementController {
    /**
     * 服务对象
     */
    @Resource
    private WorkAchievementService workAchievementService;
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private UserService userService;
    @Resource
    private CollegeService collegeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WorkAchievement selectOne(String id) {
        return this.workAchievementService.queryById(id);
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

    /**
     * 查询用户的著作成果
     * @param id
     * @return 该用户所有著作成果
     */
    @PostMapping("findOne/{id}")
    public String findOne(@PathVariable String id){
        try{
            String string="";
            String re="";
            List<WorkAchievement> workAchievements = workAchievementService.queryByUserId(id);
            if(workAchievements.size()==0){
                return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
            }else{
                if(workAchievements.size()==1){
                    string = objectMapper.writeValueAsString(workAchievements.get(0));
                    re=string.substring(0,string.length()-1)+",\"userName\":\""+userService.queryById(workAchievements.get(0).getUserId()).getName()+"\",\"collegeName\":\""+collegeService.queryById(workAchievements.get(0).getCollegeId()).getName()+"\",\"phone\":\""+userService.queryById(workAchievements.get(0).getUserId()).getPhone()+"\"}]";
                }else{
                    for(int i=0;i<workAchievements.size();i++){
                        if(i==workAchievements.size()-1){
                            string = objectMapper.writeValueAsString(workAchievements.get(i));
                            string=string.substring(0,string.length()-1)+",\"userName\":\""+userService.queryById(workAchievements.get(0).getUserId()).getName()+"\",\"collegeName\":\""+collegeService.queryById(workAchievements.get(0).getCollegeId()).getName()+"\",\"phone\":\""+userService.queryById(workAchievements.get(0).getUserId()).getPhone()+"\"}]";
                        }else{
                            string = objectMapper.writeValueAsString(workAchievements.get(i));
                            string=string.substring(0,string.length()-1)+",\"userName\":\""+userService.queryById(workAchievements.get(0).getUserId()).getName()+"\",\"collegeName\":\""+collegeService.queryById(workAchievements.get(0).getCollegeId()).getName()+"\",\"phone\":\""+userService.queryById(workAchievements.get(0).getUserId()).getPhone()+"\"},";
                        }
                        re+=string;
                    }
                }
                System.out.println("re = " + re);
                return "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":["+re+"}";
            }
        }catch (Exception e){
            e.toString();
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
        }
    }

}