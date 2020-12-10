package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:42
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    //    private final Logger loggingLogger = Logger.getLogger("loginInfo");
//    private final Logger systemLogger = Logger.getLogger("systemInfo");
    private final org.slf4j.Logger loggingLogger = LoggerFactory.getLogger("loginInfo");

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PreAuthorize("hasRole('admin1')")
    @PostMapping("/user/selectOne")
    public Message selectOne(@RequestBody String id) {
        System.out.println(id);
//        id = id.substring(0, id.length() - 1);
        String[] split = id.split(":");
        for (String s : split) {
            System.out.println(s);
        }
        id = split[1].substring(1, split[1].length() - 2);
        System.out.println(id);
        return Message.success(userService.queryById(id));
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
     * 忘记密码
     * /initPWD
     * id password 输入参数
     */
    @ResponseBody
    @PostMapping("/user/initPWD")
    public String initPWD(@RequestBody Map<String, String> map) {
        try {
            Users user = userService.queryById(map.get("id"));
            user.setPassword(map.get("password"));
            userService.update(user);
            return "{'resultCode': '0','resultMsg': '密码修改成功'}";
        } catch (Exception e) {
            System.out.println("e = " + e.toString());
            return "{'resultCode': '-1','resultMsg': '密码修改失败'}";
        }
    }
}
