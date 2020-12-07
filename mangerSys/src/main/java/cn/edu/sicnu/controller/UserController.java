package cn.edu.sicnu.controller;

import cn.edu.sicnu.controller.getRights;
import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.slf4j.LoggerFactory;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
//    @PostMapping("login")
    public String login(@RequestBody Map<String, String> map, HttpServletRequest request) {
        String ip = getRemoteHost(request);
        MDC.put("ipAddress", ip);
        Users user = userService.findByIdAndPassword(map.get("id"), map.get("password"));

        MDC.put("userId", user.getId());
        if (user == null) {
            loggingLogger.info("登录失败");
            return "{\"resultCode\": \"-1\",\"resultMsg\": \"登录失败\"}";
        } else {
            loggingLogger.info("登录成功");
            return "{\"resultCode\": \"0\",\"resultMsg\": \"登录成功\"}";
        }
    }

    /**
     * 测试
     */
//    @Secured({"ROLE_sale","ROLE_manger"})
//    @PreAuthorize("hasAnyAuthority('')")//方法执行前面判断
//    @PostAuthorize("hasAnyAuthority()")//方法执行后判断
    @PostMapping("test")
//    @PreAuthorize("hasAuthority('/reports')")
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
