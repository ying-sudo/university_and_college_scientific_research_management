package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.User;
import cn.edu.sicnu.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:42
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private getRights get;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(String id) {
        return this.userService.queryById(id);
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
     * 用户登录
     * /login
     * id password输入参数
     */
    @PostMapping("login")
    public String login(@RequestBody Map<String,String> map){
        try{
            System.out.println("id = " + map.get("id"));
            System.out.println("password = " + map.get("password"));
            User user = userService.findByIdAndPassword(map.get("id"), map.get("password"));
            String getRightsByCharacters = get.getRightsByCharacters(map.get("id"));
            if(user==null){
                return "{\"resultCode\": \"-1\",\"resultMsg\": \"登录失败\"}";
            }else {
                System.out.println("getRightsByCharacters = " + "成功");
                return "{\"resultCode\": \"0\",\"resultMsg\": \"登录成功\","+getRightsByCharacters+"}";
            }
        }catch (Exception e){
            System.out.println("e = " + e.toString());
            return "{\"resultCode\": \"-1\",\"resultMsg\": \"登录失败\"}";
        }
    }
    /**
     * 测试
     */
    @PostMapping("test")
    public String test(@RequestBody Map<String,Object> map){
        System.out.println("接受");
        for (String s : map.keySet()) {
            System.out.println("s = " + s);
            System.out.println("value = "+map.get(s));
        }
//        String getRightsByCharacters = get.getRightsByCharacters("1");
        return "";
    }
    /**
     * 忘记密码
     * /initPWD
     * id password 输入参数
     */
    @ResponseBody
    @PostMapping("initPWD")
    public String initPWD(@RequestBody Map<String,String > map){
        try{
            User user = userService.queryById(map.get("id"));
            user.setPassword(map.get("password"));
            userService.update(user);
            return "{'resultCode': '0','resultMsg': '密码修改成功'}";
        }catch (Exception e){
            System.out.println("e = " + e.toString());
            return "{'resultCode': '-1','resultMsg': '密码修改失败'}";
        }
    }
}