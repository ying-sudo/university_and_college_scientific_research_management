package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.entity.Sort;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.service.LogcolumnService;
import cn.edu.sicnu.service.LogoperationService;
import cn.edu.sicnu.service.LogtableService;
import cn.edu.sicnu.service.ProjectService;
import cn.edu.sicnu.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (Project)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:30
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("project")
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
    @Resource
    private LogtableService logtableService;
    @Resource
    private LogcolumnService logcolumnService;
    @Resource
    private LogoperationService logoperationService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Project selectOne(String id) {
        return this.projectService.queryById(id);
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
     * 查询所有项目
     * /projrct
     *
     */
    @GetMapping("projects")
    public String projects(){
        try{
            List<Project> projects = projectService.findAll();
            List<String> list = new ArrayList<>();
            String re="";
            for (Project project : projects) {
                String name = collegeService.queryById(project.getCollegeId()).getName();
                String name1 = userService.queryById(project.getUserId()).getName();
                String string = objectMapper.writeValueAsString(project);
                if(project.getState()==1){
                    re=string.substring(0,string.length()-1)+","+"\"states\":"+"\"通过\","+"\"userName\":\""+name1+"\",\"collegeName\":\""+name+"\"}";
                }else if(project.getState()==0){
                    re=string.substring(0,string.length()-1)+","+"\"states\":"+"\"未通过\","+"\"userName\":\""+name1+"\",\"collegeName\":\""+name+"\"}";
                }
                list.add(re);
            }

            String res="[";
            for (int i=0;i<list.size();i++) {
                if(i==list.size()-1){
                    res+=list.get(i);
                }else {
                    res+=list.get(i)+",";
                }
            }

            res+="]";
//            System.out.println("string = " + "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":"+res+"}");
            return "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":"+res+"}";
        }catch (Exception e){
            System.out.println("e = " + e.toString());
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
        }
    }
    /**
     * 通过用户id查询用户的所有项目
     * /project/{id}
     */
    @PostMapping("/projects/{id}")
    public String findById(@PathVariable String id){
        try {
            System.out.println("id = " + id);
            List<Project> projects = projectService.queryByUserId(id);
            List<String> list = new ArrayList<>();
            String re="";
            for (Project project : projects) {
                String name = collegeService.queryById(project.getCollegeId()).getName();
                String name1 = userService.queryById(project.getUserId()).getName();
                String string = objectMapper.writeValueAsString(project);
                if(project.getState()==1){
                    re=string.substring(0,string.length()-1)+","+"\"states\":"+"\"通过\","+"\"userName\":\""+name1+"\",\"collegeName\":\""+name+"\"}";
                }else if(project.getState()==0){
                    re=string.substring(0,string.length()-1)+","+"\"states\":"+"\"未通过\","+"\"userName\":\""+name1+"\",\"collegeName\":\""+name+"\"}";
                }
                list.add(re);
            }

            String res="[";
            for (int i=0;i<list.size();i++) {
                if(i==list.size()-1){
                    res+=list.get(i);
                }else {
                    res+=list.get(i)+",";
                }
            }

            res+="]";
            System.out.println("string = " + "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":"+res+"}");
            return "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":"+res+"}";
        }catch (Exception e){
            System.out.println("e = " + e.toString());
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
        }
    }
    /**
     * 新建项目
     *  /project
     *  project json数据
     */
    @PostMapping("projects")
    public String insertProject(@RequestBody Map<String,Object> map){
        try{
//            project.setBeginDate(new SimpleDateFormat("yyyy-yy-dd").parse("2020-12-12"));
            Project project = objectMapper.readValue(map.get("project").toString(), Project.class);
//            System.out.println("project = " + project);
            project.setRequestFund((Double)project.getRequestFund());
            project.setArrivalFund((Double)project.getArrivalFund());
            project.setState((Integer)project.getState());
//            System.out.println("project = " + project);
            List<Sort> lst =  objectMapper.readValue(map.get("users").toString(),new TypeReference<List<Sort>>(){});
            for (Sort sort : lst) {
                System.out.println("sort = " + sort);
            }
//            System.out.println("map = " +lst.get(0));
//            projectService.insert(project);
            /*Logtable logtable = new Logtable();
            logtable.setTableName("project");
            logtable.setBussinessName("新增项目");
            logtable.setCreateTime(new Date());
            int tableId = logtableService.insert(logtable);
            System.out.println("tableId = " + tableId);
            Logcolumn logcolumn = new Logcolumn();
            logcolumn.setLogtableId(tableId);
            logcolumn.setLogcolumn("All");
            int columnId = logcolumnService.insert(logcolumn);
            System.out.println("columnId = " + columnId);
            Logoperation logoperation = new Logoperation();
            logoperation.setLogtableId(tableId);
            logoperation.setLogcolumnId(columnId);
            logoperation.setOptionType("增加");
            logoperation.setUserId("2011000416");
            logoperationService.insert(logoperation);*/
            logtableService.deleteById(1);
            return "{\"resultCode\":\"0\",\"resultMsg\":\"请求成功\"}";
        }catch (Exception e){
            System.out.println("e = " + e.toString());
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"内部异常\"}";
        }
    }
    /**
     * 修改项目信息
     * /project/{id}
     * project json数据
     */
    @PutMapping("/projects/{id}")
    public String updataProject(@RequestBody Project project, @PathVariable String id){
        try{
            System.out.println("project = " + project.toString());
            System.out.println("id = " + id);
            projectService.update(project);
            return "{\"resultCode\":\"0\",\"resultMsg\":\"请求成功\"}";
        }catch (Exception e){
            System.out.println("e = " + e.toString());
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"内部异常\"}";
        }
    }
}