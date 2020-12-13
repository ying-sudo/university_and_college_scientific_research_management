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
 * @author makejava, liangjin
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

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 查询所有项目
     *
     * @return
     */
    @GetMapping("/projects")
    public String findAll() {
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
     *
     * @param userId 用户id
     * @return 以该用户id为项目负责人的所有项目
     */
    @GetMapping("/projects/users/{userId}")
    public String findById(@PathVariable("userId") String userId) {
        try {
            System.out.println("userId = " + userId);
            List<Project> projects = projectService.queryByUserId(userId);
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
     * 根据项目id得到一个项目的详细信息
     *
     * @param projectId 项目id
     * @return 如果存在，返回message中data为项目的实体类信息；如果不存在，返回的message中data为null
     */
    @GetMapping("/projects/{projectId}")
    public Message findByProjectId(@PathVariable("projectId") String projectId) {
        Project project = projectService.queryById(projectId);
        return Message.success(project);
    }

    /**
     * 新建项目
     *
     * @param project 传入的项目对象
     * @return message成功时返回中状态码为0，
     * 其余都为操作失败，包括出现异常
     */
    @PostMapping("/projects")
    public Message insert(@RequestBody Project project) {
        project = projectService.insert(project);
        if (project != null) {
            operLogger.info("新建项目成功");
            return Message.success();
        }
        operLogger.warn("新建项目失败");
        return Message.fail();
    }

    /**
     * 修改项目信息
     *
     * @param project 修改的项目对象
     * @param session
     * @return message成功时返回中状态码为0，
     * 其余都为操作失败，包括出现异常
     */
    @PutMapping("/projects")
    public Message update(@RequestBody Project project, HttpSession session) {
        MDC.clear();
        MDC.put("userId", String.valueOf(session.getAttribute("userId")));
        MDC.clear();
//        System.out.println(project);
//        System.out.println("project = " + project.toString());
//        System.out.println("id = " + id);
        project = projectService.update(project);
        if (project != null) {
            operLogger.info("修改项目成功");
            return Message.success(null);
        }
        operLogger.warn("修改项目失败");
        return Message.fail();
    }

    /**
     * 根据项目id删除项目
     *
     * @param projectId 项目id
     * @return 删除成功状态码为0，失败为其他
     */
    @DeleteMapping("/projects/{projectId}")
    public Message delete(@PathVariable("projectId") String projectId) {
        boolean delete = projectService.deleteById(projectId);
        return delete ? Message.success(null) : Message.fail();
    }
}