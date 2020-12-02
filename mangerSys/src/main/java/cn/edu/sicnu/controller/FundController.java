package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Fund;
import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.service.FundService;
import cn.edu.sicnu.service.ProjectService;
import cn.edu.sicnu.service.UserService;
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
 * (Fund)表控制层
 *
 * @author makejava
 * @since 2020-11-27 10:05:14
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("fund")
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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Fund selectOne(String id) {
        return this.fundService.queryById(id);
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
     * 通过项目id获取项目的所有经费记录
     * 项目id 参数
     */
    @PostMapping("fund/{id}")
    public String getFundByProjectId(@PathVariable String id){
        String re="";
        try {
            List<Project> projects = projectService.queryByUserId(id);
//            System.out.println("projects = " + projects.toString());
            System.out.println(projects.size());
            for (int i=0;i<projects.size();i++) {
//                System.out.println(projects.get(i).getId());
                List<Fund> fundByProjectId = fundService.getFundByProjectId(projects.get(i).getId());
//                System.out.println("fundByProjectId = " + fundByProjectId);
                String string = objectMapper.writeValueAsString(fundByProjectId);
                System.out.println("as = " + string);
                if(string.equals("[]")){
                    string="[{\"projectId\":"+projects.get(i).getId()+",\"requestFund\":0"+",\"arrivalFund\":0"+",\"requestDate\":0"+",\"arrivalDate\":0" +",\"projectName\":\""+projects.get(i).getName()+"\",\"userName\":\""+userService.queryById(projects.get(i).getUserId()).getName()+"\",\"projectId\":"+projects.get(i).getId()+"\"projectSort\":\""+projects.get(i).getSort()+"\"}";
                    re+=string;
                    if(projects.size()==1){
                        re+="";
                    }else{
                        re+=",";
                    }
                    continue;
                }
                if(projects.size()==1){
                    string=string.substring(0,string.length()-2)+",\"projectName\":\""+projects.get(i).getName()+"\",\"userName\":\""+userService.queryById(projects.get(i).getUserId()).getName()+"\",\"projectId\":"+projects.get(i).getId()+",\"projectSort\":\""+projects.get(i).getSort()+"\"}]";
                }else if(i==0&&projects.size()!=1){
                    string=string.substring(0,string.length()-2)+",\"projectName\":\""+projects.get(i).getName()+"\",\"userName\":\""+userService.queryById(projects.get(i).getUserId()).getName()+"\",\"projectId\":"+projects.get(i).getId()+",\"projectSort\":\""+projects.get(i).getSort()+"\"},";
                }else if(i!=0&&i==projects.size()-1){
                    string=string.substring(1,string.length()-2)+",\"projectName\":\""+projects.get(i).getName()+"\",\"userName\":\""+userService.queryById(projects.get(i).getUserId()).getName()+"\",\"projectId\":"+projects.get(i).getId()+",\"projectSort\":\""+projects.get(i).getSort()+"\"}]";
                }else{
                    string=string.substring(1,string.length()-2)+",\"projectName\":\""+projects.get(i).getName()+"\",\"userName\":\""+userService.queryById(projects.get(i).getUserId()).getName()+"\",\"projectId\":"+projects.get(i).getId()+",\"projectSort\":\""+projects.get(i).getSort()+"\"}"+",";
                }
                re+=string;
            }
            System.out.println("re = " + re);
            return "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":"+re+"}";
        } catch (Exception e) {
            e.toString();
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
        }
    }

}