package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.PaperAchievement;
import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.PaperAchievementService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    private ObjectMapper objectMapper;
    @Resource
    private UserService userService;
    @Resource
    private CollegeService collegeService;
    @Autowired
    private Message message;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PaperAchievement selectOne(String id) {
        return this.paperAchievementService.queryById(id);
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
     * 通过用户id查询论文成果
     * @return 相关数据
     */
    @PostMapping("/paperAchievement/findOne/{id}")
    public String findOne(@PathVariable String id){
        try{
            String string="";
            String re="";
            List<PaperAchievement> paperAchievements = paperAchievementService.queryByUserId(id);
            if(paperAchievements.size()==0){
                return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
            }else{
                if(paperAchievements.size()==1){
                    string = objectMapper.writeValueAsString(paperAchievements.get(0));
                    re=string.substring(0,string.length()-1)+",\"userName\":\""+userService.queryById(paperAchievements.get(0).getUserId()).getName()+"\",\"collegeName\":\""+collegeService.queryById(paperAchievements.get(0).getCollegeId()).getName()+"\",\"phone\":\""+userService.queryById(paperAchievements.get(0).getUserId()).getPhone()+"\"}]";
                }else{
                    for(int i=0;i<paperAchievements.size();i++){
                        if(i==paperAchievements.size()-1){
                            string = objectMapper.writeValueAsString(paperAchievements.get(i));
                            string=string.substring(0,string.length()-1)+",\"userName\":\""+userService.queryById(paperAchievements.get(0).getUserId()).getName()+"\",\"collegeName\":\""+collegeService.queryById(paperAchievements.get(0).getCollegeId()).getName()+"\",\"phone\":\""+userService.queryById(paperAchievements.get(0).getUserId()).getPhone()+"\"}]";
                        }else{
                            string = objectMapper.writeValueAsString(paperAchievements.get(i));
                            string=string.substring(0,string.length()-1)+",\"userName\":\""+userService.queryById(paperAchievements.get(0).getUserId()).getName()+"\",\"collegeName\":\""+collegeService.queryById(paperAchievements.get(0).getCollegeId()).getName()+"\",\"phone\":\""+userService.queryById(paperAchievements.get(0).getUserId()).getPhone()+"\"},";
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

    @PutMapping("/paperAchievement")
    public Message add(@RequestBody Map<String, Object> map) throws JsonProcessingException {
        System.out.println(map.get("paperAchievement"));
        PaperAchievement paperAchievement = objectMapper.readValue(map.get("paperAchievement").toString(), PaperAchievement.class);

        System.out.println(paperAchievement);
        paperAchievementService.insert(paperAchievement);
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(null);
        return message;
    }

}