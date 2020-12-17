package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.EvaluationResult;
import cn.edu.sicnu.entity.PaperAchievement;
import cn.edu.sicnu.entity.PatentAchievement;
import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.entity.ProjectAchievemUser;
import cn.edu.sicnu.entity.ScientificAchievement;
import cn.edu.sicnu.entity.Sort;
import cn.edu.sicnu.entity.WorkAchievement;
import cn.edu.sicnu.service.EvaluationResultService;
import cn.edu.sicnu.service.PaperAchievementService;
import cn.edu.sicnu.service.PatentAchievementService;
import cn.edu.sicnu.service.ProjectAchievemUserService;
import cn.edu.sicnu.service.ProjectService;
import cn.edu.sicnu.service.ScientificAchievementService;
import cn.edu.sicnu.service.SortService;
import cn.edu.sicnu.service.WorkAchievementService;
import cn.edu.sicnu.utils.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (Sort)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:33
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SortController {
    /**
     * 服务对象
     */
    @Resource
    private SortService sortService;
    @Resource
    private ProjectAchievemUserService projectAchievemUserService;
    @Resource
    private ProjectService projectService;
    @Resource
    private PaperAchievementService paperAchievementService;
    @Resource
    private PatentAchievementService patentAchievementService;
    @Resource
    private ScientificAchievementService scientificAchievementService;
    @Resource
    private WorkAchievementService workAchievementService;
    @Resource
    private EvaluationResultService evaluationResultService;


    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 查询所有
     *
     * @return 所有数据
     */
//    @PreAuthorize("hasAnyAuthority()")
    @GetMapping("/sorts")
    public String findAll() {
        String re = "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":{";

        List<Sort> sorts = sortService.selectByNote("1");
        re += "\"firstDiscipline\":[";
        for (int i = 0; i < sorts.size(); i++) {
            if (i == sorts.size() - 1) {
                re += "\"" + sorts.get(i).getValue() + "\"],";
            } else {
                re += "\"" + sorts.get(i).getValue() + "\",";
            }
        }

        List<Sort> sorts1 = sortService.selectByNote("2");
        re += "\"level\":[";
        for (int i = 0; i < sorts1.size(); i++) {
            if (i == sorts1.size() - 1) {
                re += "\"" + sorts1.get(i).getValue() + "\"],";
            } else {
                re += "\"" + sorts1.get(i).getValue() + "\",";
            }
        }

        List<Sort> sorts2 = sortService.selectByNote("3");
        re += "\"sort\":[";
        for (int i = 0; i < sorts2.size(); i++) {
            if (i == sorts2.size() - 1) {
                re += "\"" + sorts2.get(i).getValue() + "\"]";
            } else {
                re += "\"" + sorts2.get(i).getValue() + "\",";
            }
        }
        re += "}}";
        return re;
    }

    /**
     * 根据类别(对应sort表中note)查询
     * 1 一级学科
     * 2 学科等级
     * 3 学科分类
     *
     * @param kindId 类别id
     * @return 查询数据放入data
     */
//    @PreAuthorize("hasAnyAuthority()")
    @GetMapping("/sorts/{kindId}")
    public Message find(@PathVariable("kindId") String kindId) {
        List<Sort> sorts = sortService.selectByNote(kindId);
        return Message.success(sorts);
    }

    /**
     * 新增字典项
     * 1 一级学科
     * 2 学科等级
     * 3 学科分类
     *
     * @param sort 多个字典项对应实体类的list
     * @return 新增成功返回状态码为0，失败返回其他状态码
     */
//    @PreAuthorize("hasAnyAuthority()")
    @PostMapping("/sorts")
    public Message insert(@RequestBody List<Sort> sort) {
        boolean insert = sortService.insert(sort);
        if (insert) {
            operLogger.info("新增字典项成功");
            return Message.success();
        }
        operLogger.info("新增字典项失败");
        return Message.fail();
    }

    /**
     * 修改字典项
     *
     * @param sortList 字典项对应实体类
     * @return 修改成功返回状态码为0，失败返回其他状态码
     */
//    @PreAuthorize("hasAnyAuthority()")
    @PutMapping("/sorts")
    public Message update(@RequestBody List<Sort> sortList) {
        boolean update = sortService.update(sortList);
        if (update) {
            operLogger.info("修改字典项成功");
            return Message.success();
        }
        operLogger.info("修改字典项失败");
        return Message.fail();
    }

    /**
     * 删除对应id(主码)的字典项
     *
     * @param sortId 字典项id
     * @return 删除成功返回状态码为0，失败返回其他状态码
     */
//    @PreAuthorize("hasAnyAuthority()")
    @DeleteMapping("/sorts/{sortId}")
    public Message delete(@PathVariable("sortId") Integer sortId) {
        boolean delete = sortService.deleteById(sortId);
        if (delete) {
            operLogger.info("删除字典项成功");
            return Message.success();
        }
        operLogger.info("删除字典项失败");
        return Message.fail();
    }

    /**
     * 插入成员接口
     */
    @PostMapping("/sorts/insertUsers")
    public Message insertUsers(@RequestBody List<ProjectAchievemUser> list){
        try{
            for (ProjectAchievemUser projectAchievemUser : list) {
                projectAchievemUserService.insert(projectAchievemUser);
            }
            operLogger.info("插入projectAchievementUser成功");
            return Message.success();
        }catch (Exception e){
            projectService.deleteById(list.get(0).getId());
            return Message.fail();
        }
    }
    /**
     * 查看项目成果等数量
     *
     */
    @PostMapping("/home/overview")
    public Message getAllViews(@RequestBody String id){
        System.out.println("id1 = " + id);
        List<Integer> list = new ArrayList<>();
        try {
            //project表中查询用户参与的项目数量
            List<Project> projects = projectService.queryByUserId(id);
            list.add(projects.size());
            //paperAchievement表中查询用户参与的数量
            List<PaperAchievement> paperAchievements = paperAchievementService.queryByUserId(id);
            list.add(paperAchievements.size());
            //patentAchievement表中查询用户参与的数量
            List<PatentAchievement> patentAchievements = patentAchievementService.queryByUserId(id);
            list.add(patentAchievements.size());
            //scientificAchievement表中用户参与的数量
            List<ScientificAchievement> scientificAchievements = scientificAchievementService.queryByUserId(id);
            list.add(scientificAchievements.size());
            //workAchievement表中用户参与的数量
            List<WorkAchievement> workAchievements = workAchievementService.queryByUserId(id);
            list.add(workAchievements.size());
            String data="{\"project\":"+list.get(0)+",\"paper\":"+list.get(1)+",\"patent\":"+list.get(2)+",\"scientific\":"+list.get(3)+",\"work\":"+list.get(4)+"}";
            return Message.success(data);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail();
        }
    }
    /**
     * 查询所有成果的成绩
     *
     */
    @PostMapping("/home/assessmentresult")
    public Message getAssessmentresult(@RequestBody String id){
        List<List> list = new ArrayList<>();
        List<Integer> li0=new ArrayList<>();
        List<Integer> li1=new ArrayList<>();
        List<Integer> li2=new ArrayList<>();
        List<Integer> li3=new ArrayList<>();
        List<Integer> li4=new ArrayList<>();

        try{
            //project表中查询用户参与的项目数量
            System.out.println("id = " + id);
            List<Project> projects = projectService.queryByUserId(id);
            for (Project project : projects) {
                System.out.println("project = " + project);
                EvaluationResult evaluationResult0 = evaluationResultService.queryById(project.getId());
                if(evaluationResult0!=null){
                    li0.add(evaluationResult0.getScore());
                }
            }
            System.out.println("li0 = " + li0);
            list.add(li0);
            //paperAchievement表中查询用户参与的数量
            List<PaperAchievement> paperAchievements = paperAchievementService.queryByUserId(id);
            for (PaperAchievement paperAchievement : paperAchievements) {
                EvaluationResult evaluationResult1 = evaluationResultService.queryById(paperAchievement.getId());
                if(evaluationResult1!=null){
                    li1.add(evaluationResult1.getScore());
                }
            }
            list.add(li1);
            //patentAchievement表中查询用户参与的数量
            List<PatentAchievement> patentAchievements = patentAchievementService.queryByUserId(id);
            for (PatentAchievement patentAchievement : patentAchievements) {
                EvaluationResult evaluationResult2 = evaluationResultService.queryById(patentAchievement.getId());
                if(evaluationResult2!=null){
                    li2.add(evaluationResult2.getScore());
                }
            }
            list.add(li2);
            //scientificAchievement表中用户参与的数量
            List<ScientificAchievement> scientificAchievements = scientificAchievementService.queryByUserId(id);
            for (ScientificAchievement scientificAchievement : scientificAchievements) {
                EvaluationResult evaluationResult3 = evaluationResultService.queryById(scientificAchievement.getId());
                if(evaluationResult3!=null){
                    li3.add(evaluationResult3.getScore());
                }
            }
            list.add(li3);
            //workAchievement表中用户参与的数量
            List<WorkAchievement> workAchievements = workAchievementService.queryByUserId(id);
            for (WorkAchievement workAchievement : workAchievements) {
                EvaluationResult evaluationResult4 = evaluationResultService.queryById(workAchievement.getId());
                if(evaluationResult4!=null){
                    li4.add(evaluationResult4.getScore());
                }
            }
            list.add(li4);
            String data="{\"project\":"+list.get(0)+",\"paper\":"+list.get(1)+",\"patent\":"+list.get(2)+",\"scientific\":"+list.get(3)+",\"work\":"+list.get(4)+"}";
            return Message.success(data);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail();
        }
    }
}