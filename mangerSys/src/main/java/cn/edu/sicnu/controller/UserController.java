package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * (Users)表控制层
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

//    private final Logger loggingLogger = Logger.getLogger("loginInfo");
//    private final Logger systemLogger = Logger.getLogger("systemInfo");
    private final org.slf4j.Logger loggingLogger = LoggerFactory.getLogger("loginInfo");
    private final org.slf4j.Logger systemLogger = LoggerFactory.getLogger("systemInfo");

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Users selectOne(String id) {
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
     * @param request 请求
     */
    private static String getRemoteHost(HttpServletRequest request) {
        // 反向代理后：转发请求的HTTP头信息中，增加了X-Real-IP信息
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("x-Forwarded-For");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 用户登录
     * /login
     * id password输入参数
     */
    @PostMapping("login")
    public String login(@RequestBody Map<String, String> map, HttpServletRequest request) {
        String ip = getRemoteHost(request);
        System.out.println(ip);
        MDC.put("ipAddress", ip);
        try {
            System.out.println("id = " + map.get("id"));
            System.out.println("password = " + map.get("password"));
            Users users = userService.findByIdAndPassword(map.get("id"), map.get("password"));
            System.out.println("users = " + users.toString());
//            String getRightsByCharacters = get.getRightsByCharacters(users.getId());
            MDC.put("userId", users.getId());
            if (users == null) {
                loggingLogger.info("登录失败");
                return "{\"resultCode\": \"-1\",\"resultMsg\": \"登录失败\"}";
            } else {
                loggingLogger.info("登录成功");
                return "{\"resultCode\": \"0\",\"resultMsg\": \"登录成功\"}";
            }
        } catch (Exception e) {
//            System.out.println("e = " + e.toString());
            systemLogger.error(e.toString());
            loggingLogger.info("登录失败");
            return "{\"resultCode\": \"-1\",\"resultMsg\": \"登录失败\"}";
        }
    }

    /**
     * 测试
     */
    @PostMapping("test")
    public String test(@RequestBody Map<String, Object> map) {
        System.out.println("接受");
        for (String s : map.keySet()) {
            System.out.println("s = " + s);
            System.out.println("value = " + map.get(s));
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
    public String initPWD(@RequestBody Map<String, String> map) {
        try {
            Users users = userService.queryById(map.get("id"));
            users.setPassword(map.get("password"));
            userService.update(users);
            return "{'resultCode': '0','resultMsg': '密码修改成功'}";
        } catch (Exception e) {
            System.out.println("e = " + e.toString());
            return "{'resultCode': '-1','resultMsg': '密码修改失败'}";
        }
    }
}