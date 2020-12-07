package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.ProjectService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * (Project)项目表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:30
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProjectController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectService projectService;
    @Autowired
    private ObjectMapper objectMapper;
    @Resource
    private CollegeService collegeService;
    @Resource
    private UserService userService;
//    @Resource
//    private LogtableService logtableService;
//    @Resource
//    private LogcolumnService logcolumnService;
//    @Resource
//    private LogoperationService logoperationService;

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/project/selectOne")
    public Project selectOne(String id) {
        return this.projectService.queryById(id);
    }

    /**
     * 查询所有项目
     * /projrct
     */
    @GetMapping("/project/projects")
    public String projects() {
        try {
            List<Project> projects = projectService.findAll();
            List<String> list = new ArrayList<>();
            String re = "";
            for (Project project : projects) {
                String name = collegeService.queryById(project.getCollegeId()).getName();
                String name1 = userService.queryById(project.getUserId()).getName();
                String string = objectMapper.writeValueAsString(project);
                if (project.getState() == 1) {
                    re = string.substring(0, string.length() - 1) + "," + "\"states\":" + "\"通过\"," + "\"userName\":\"" + name1 + "\",\"collegeName\":\"" + name + "\"}";
                } else if (project.getState() == 0) {
                    re = string.substring(0, string.length() - 1) + "," + "\"states\":" + "\"未通过\"," + "\"userName\":\"" + name1 + "\",\"collegeName\":\"" + name + "\"}";
                }
                list.add(re);
            }

            String res = "[";
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    res += list.get(i);
                } else {
                    res += list.get(i) + ",";
                }
            }

            res += "]";
//            System.out.println("string = " + "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":"+res+"}");
            return "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":" + res + "}";
        } catch (Exception e) {
            System.out.println("e = " + e.toString());
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
        }
    }

    /**
     * 通过用户id查询用户的所有项目
     * /project/{id}
     */
    @PostMapping("/projects/{id}")
    public String findById(@PathVariable String id) {
        try {
            System.out.println("id = " + id);
            List<Project> projects = projectService.queryByUserId(id);
            List<String> list = new ArrayList<>();
            String re = "";
            for (Project project : projects) {
                String name = collegeService.queryById(project.getCollegeId()).getName();
                String name1 = userService.queryById(project.getUserId()).getName();
                String string = objectMapper.writeValueAsString(project);
                if (project.getState() == 1) {
                    re = string.substring(0, string.length() - 1) + "," + "\"states\":" + "\"通过\"," + "\"userName\":\"" + name1 + "\",\"collegeName\":\"" + name + "\"}";
                } else if (project.getState() == 0) {
                    re = string.substring(0, string.length() - 1) + "," + "\"states\":" + "\"未通过\"," + "\"userName\":\"" + name1 + "\",\"collegeName\":\"" + name + "\"}";
                }
                list.add(re);
            }

            String res = "[";
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    res += list.get(i);
                } else {
                    res += list.get(i) + ",";
                }
            }

            res += "]";
            System.out.println("string = " + "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":" + res + "}");
            return "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":" + res + "}";
        } catch (Exception e) {
            System.out.println("e = " + e.toString());
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
        }
    }

    /**
     * 新建项目
     *
     * @param project 传入的项目对象
     * @param session
     * @return message成功时返回中状态码为0，
     * 其余都为操作失败，包括出现异常
     */
    @PostMapping("/project/projects")
    public Message insertProject(@RequestBody Project project, HttpSession session) {
        MDC.clear();
        MDC.put("userId", String.valueOf(session.getAttribute("userId")));
        MDC.clear();
        System.out.println(project);
//            project.setBeginDate(new SimpleDateFormat("yyyy-yy-dd").parse("2020-12-12"));
//            Project project = objectMapper.readValue(project.get("project").toString(), Project.class);
//            project.setRequestFund((Double)project.getRequestFund());
//            project.setArrivalFund((Double)project.getArrivalFund());
//            project.setState((Integer)project.getState());
//            System.out.println(project);
        project = projectService.insert(project);
        if (project != null) {
            operLogger.info("新建项目成功");
            return Message.success(null);
        }
//            System.out.println("sfawe");
        operLogger.warn("新建项目失败");
        return Message.fail();
    }

    /**
     * 修改项目信息
     *
     * @param project 修改的项目对象
     * @param id      项目id
     * @param session
     * @return message成功时返回中状态码为0，
     * 其余都为操作失败，包括出现异常
     */
    @PutMapping("/projects/{id}")
    public Message updataProject(@RequestBody Project project, @PathVariable String id, HttpSession session) {
        MDC.clear();
        MDC.put("userId", String.valueOf(session.getAttribute("userId")));
        MDC.clear();
        System.out.println("project = " + project.toString());
        System.out.println("id = " + id);
        project = projectService.update(project);
        if (project != null) {
            operLogger.info("修改项目成功");
            return Message.success(null);
        }
        operLogger.warn("修改项目失败");
        return Message.fail();
    }
}