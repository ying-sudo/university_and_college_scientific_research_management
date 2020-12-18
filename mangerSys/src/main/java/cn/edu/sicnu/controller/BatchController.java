package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Batch;
import cn.edu.sicnu.entity.PaperAchievement;
import cn.edu.sicnu.entity.PatentAchievement;
import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.entity.Reports;
import cn.edu.sicnu.entity.ScientificAchievement;
import cn.edu.sicnu.entity.WorkAchievement;
import cn.edu.sicnu.mapper.PaperAchievementTestDao;
import cn.edu.sicnu.mapper.ScientificAchievementTestDao;
import cn.edu.sicnu.mapper.WorkAchievementTestDao;
import cn.edu.sicnu.service.BatchService;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.PaperAchievementService;
import cn.edu.sicnu.service.PatentAchievementService;
import cn.edu.sicnu.service.ProjectService;
import cn.edu.sicnu.service.ScientificAchievementService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.service.WorkAchievementService;
import cn.edu.sicnu.utils.Message;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * (Batch)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:23
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BatchController {
    /**
     * 服务对象
     */
    @Resource
    private BatchService batchService;
    @Resource
    private ProjectService projectService;
    @Resource
    private PaperAchievementTestDao paperAchievementTestDao;
    @Resource
    private PatentAchievementService patentAchievementService;
    @Resource
    private ScientificAchievementTestDao scientificAchievementTestDao;
    @Resource
    private WorkAchievementTestDao workAchievementTestDao;
    @Resource
    private UserService userService;
    @Resource
    private CollegeService collegeService;

    /**
     * 统计报表的数据
     */
    @PreAuthorize("hasAnyAuthority('/table/reports')")
    @GetMapping("/batch/getData/{userId}")
    public Message getData(@PathVariable String userId){
        List<Reports> list=new ArrayList<>();
        List<Integer> li0=new ArrayList<>();
        List<Integer> li1=new ArrayList<>();
        List<Integer> li2=new ArrayList<>();
        List<Integer> li3=new ArrayList<>();
        List<Integer> li4=new ArrayList<>();
        Integer sum1=0;
        Integer sum2=0;
        try{
            //获取用户项目的相关信息
            List<Project> projects = projectService.queryByUserId(userId);
            li0.add(projects.size());
            for (Project project : projects) {
                if(project.getState()==1){
                    sum1++;
                }else if(project.getState()==2){
                    sum2++;
                }
            }
            li0.add(sum2);
            li0.add(sum1);
            Reports reports0 = new Reports("项目", userService.queryById(userId).getName(), collegeService.queryById(userService.queryById(userId).getCollegeId()).getName(), li0.get(0), li0.get(1), li0.get(2));
            list.add(reports0);
            //获取论文成果的相关信息
            sum1=0;
            sum2=0;
            QueryWrapper<PaperAchievement> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",userId);
            List<PaperAchievement> paperAchievements = paperAchievementTestDao.selectList(wrapper);
            li1.add(paperAchievements.size());
            for (PaperAchievement paperAchievement : paperAchievements) {
                if(paperAchievement.getState()==1){
                    sum1++;
                }else if(paperAchievement.getState()==2){
                    sum2++;
                }
            }
            li1.add(sum2);
            li1.add(sum1);
            Reports reports1 = new Reports("论文成果", userService.queryById(userId).getName(), collegeService.queryById(userService.queryById(userId).getCollegeId()).getName(), li1.get(0), li1.get(1), li1.get(2));
            list.add(reports1);
            //获取专利的相关信息
            sum1=0;
            sum2=0;
            List<PatentAchievement> patentAchievements = patentAchievementService.queryByUserId(userId);
            li2.add(patentAchievements.size());
            for (PatentAchievement patentAchievement : patentAchievements) {
                if(patentAchievement.getState()==1){
                    sum1++;
                }else if(patentAchievement.getState()==2){
                    sum2++;
                }
            }
            li2.add(sum2);
            li2.add(sum1);
            Reports reports2 = new Reports("专利成果", userService.queryById(userId).getName(), collegeService.queryById(userService.queryById(userId).getCollegeId()).getName(), li2.get(0), li2.get(1), li2.get(2));
            list.add(reports2);
            //获取科研成果的相关信息
            sum1=0;
            sum2=0;
            QueryWrapper<ScientificAchievement> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("user_id",userId);
            List<ScientificAchievement> scientificAchievements = scientificAchievementTestDao.selectList(wrapper1);
            li3.add(scientificAchievements.size());
            for (ScientificAchievement scientificAchievement : scientificAchievements) {
                if(scientificAchievement.getState()==1){
                    sum1++;
                }else if(scientificAchievement.getState()==2){
                    sum2++;
                }
            }
            li3.add(sum2);
            li3.add(sum1);
            Reports reports3 = new Reports("科研成果", userService.queryById(userId).getName(), collegeService.queryById(userService.queryById(userId).getCollegeId()).getName(), li3.get(0), li3.get(1), li3.get(2));
            list.add(reports3);
            //获取著作成果的相关信息
            sum1=0;
            sum2=0;
            QueryWrapper<WorkAchievement> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("user_id",userId);
            List<WorkAchievement> workAchievements = workAchievementTestDao.selectList(wrapper2);
            li4.add(workAchievements.size());
            for (WorkAchievement workAchievement : workAchievements) {
                if(workAchievement.getState()==1){
                    sum1++;
                }else if(workAchievement.getState()==2){
                    sum2++;
                }
            }
            li4.add(sum2);
            li4.add(sum1);
            Reports reports4 = new Reports("著作成果", userService.queryById(userId).getName(), collegeService.queryById(userService.queryById(userId).getCollegeId()).getName(), li4.get(0), li4.get(1), li4.get(2));
            list.add(reports4);
            return Message.success(list);
        }catch (Exception e){
            return Message.fail();
        }
    }

}