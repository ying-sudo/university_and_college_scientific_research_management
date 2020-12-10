package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Fund;
import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.service.FundService;
import cn.edu.sicnu.service.ProjectService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Fund)经费表控制层
 *
 * @author makejava
 * @since 2020-11-27 10:05:14
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FundController {
    /**
     * 服务对象
     */
    @Resource
    private FundService fundService;
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private ProjectService projectService;
    @Resource
    private UserService userService;

    /**
     * 查看所有经费记录
     *
     * @return 经费记录列表
     */
    @GetMapping("/funds")
    public Message getFunds() {
        List<Fund> fundList = fundService.findAll();
        return Message.success(fundList);
    }

    /**
     * 通过项目id获取项目的所有经费记录
     * 项目id 参数
     */
    @GetMapping("/funds/projects/{projectId}")
    public String getFundByProjectId(@PathVariable("projectId") String id) {
        String re = "";
        try {
            List<Project> projects = projectService.queryByUserId(id);
//            System.out.println("projects = " + projects.toString());
            System.out.println(projects.size());
            for (int i = 0; i < projects.size(); i++) {
//                System.out.println(projects.get(i).getId());
                List<Fund> fundByProjectId = fundService.getFundByProjectId(projects.get(i).getId());
//                System.out.println("fundByProjectId = " + fundByProjectId);
                String string = objectMapper.writeValueAsString(fundByProjectId);
                System.out.println("as = " + string);
                if (string.equals("[]")) {
                    string = "[{\"projectId\":" + projects.get(i).getId() + ",\"requestFund\":0" + ",\"arrivalFund\":0" + ",\"requestDate\":0" + ",\"arrivalDate\":0" + ",\"projectName\":\"" + projects.get(i).getName() + "\",\"userName\":\"" + userService.queryById(projects.get(i).getUserId()).getName() + "\",\"projectId\":" + projects.get(i).getId() + "\"projectSort\":\"" + projects.get(i).getSort() + "\"}";
                    re += string;
                    if (projects.size() == 1) {
                        re += "";
                    } else {
                        re += ",";
                    }
                    continue;
                }
                if (projects.size() == 1) {
                    string = string.substring(0, string.length() - 2) + ",\"projectName\":\"" + projects.get(i).getName() + "\",\"userName\":\"" + userService.queryById(projects.get(i).getUserId()).getName() + "\",\"projectId\":" + projects.get(i).getId() + ",\"projectSort\":\"" + projects.get(i).getSort() + "\"}]";
                } else if (i == 0 && projects.size() != 1) {
                    string = string.substring(0, string.length() - 2) + ",\"projectName\":\"" + projects.get(i).getName() + "\",\"userName\":\"" + userService.queryById(projects.get(i).getUserId()).getName() + "\",\"projectId\":" + projects.get(i).getId() + ",\"projectSort\":\"" + projects.get(i).getSort() + "\"},";
                } else if (i != 0 && i == projects.size() - 1) {
                    string = string.substring(1, string.length() - 2) + ",\"projectName\":\"" + projects.get(i).getName() + "\",\"userName\":\"" + userService.queryById(projects.get(i).getUserId()).getName() + "\",\"projectId\":" + projects.get(i).getId() + ",\"projectSort\":\"" + projects.get(i).getSort() + "\"}]";
                } else {
                    string = string.substring(1, string.length() - 2) + ",\"projectName\":\"" + projects.get(i).getName() + "\",\"userName\":\"" + userService.queryById(projects.get(i).getUserId()).getName() + "\",\"projectId\":" + projects.get(i).getId() + ",\"projectSort\":\"" + projects.get(i).getSort() + "\"}" + ",";
                }
                re += string;
            }
            System.out.println("re = " + re);
            return "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":" + re + "}";
        } catch (Exception e) {
            e.toString();
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
        }
    }

}