package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.User;
import cn.edu.sicnu.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:42
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

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
     * /login
     * id password输入参数
     */
    @ResponseBody
    @PostMapping("login")
    public String login(String id,String password){
        try{
            User user = userService.findByIdAndPassword(id, password);
            if(user==null){
                return "{'resultCode': '-1','resultMsg': '登录失败'}";
            }else {
                return "{'resultCode': '0','resultMsg': '登录成功'}";
            }
        }catch (Exception e){
            return "{'resultCode': '-1','resultMsg': '登录失败'}";
        }
    }
    /**
     * /initPWD
     * id password 输入参数
     */
    @ResponseBody
    @PostMapping("initPWD")
    public String initPWD(String id,String password){
        try{
            User user = userService.queryById(id);
            user.setPassword(password);
            userService.update(user);
            return "{'resultCode': '0','resultMsg': '密码修改成功'}";
        }catch (Exception e){
            return "{'resultCode': '-1','resultMsg': '密码修改失败'}";
        }
    }
}