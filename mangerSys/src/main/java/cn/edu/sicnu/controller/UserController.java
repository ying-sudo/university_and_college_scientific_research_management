package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.sercurity.utils.DefaultPasswordEncoder;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private DefaultPasswordEncoder defaultPasswordEncoder;

    //    private final Logger loggingLogger = Logger.getLogger("loginInfo");
//    private final Logger systemLogger = Logger.getLogger("systemInfo");
    private final org.slf4j.Logger loggingLogger = LoggerFactory.getLogger("loginInfo");

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PreAuthorize("hasAnyAuthority('/table/teams')")
    @PostMapping("/user/selectOne")
    public Message selectOne(@RequestBody String id) {
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
    @PostMapping("/user/initPWD")
    public Message initPWD(@RequestBody Map<String, String> map) {
        try {
            Users user = userService.queryById(map.get("id"));
            if(map.get("identify").equals(user.getIdNumber())){
                user.setPassword(defaultPasswordEncoder.encode(map.get("password")));
                userService.update(user);
                return Message.success();
            }else{
                return Message.fail();
            }
        } catch (Exception e) {
            System.out.println("e = " + e.toString());
            return Message.fail();
        }
    }
    /**
     * 查询个人信息
     */
    @PreAuthorize("hasAnyAuthority('/home')")
    @PostMapping("user/getOneInformation")
    public Message getOne(@RequestBody String id){
        Users users = userService.queryById(id);
        System.out.println("users = " + users.toString());
        try {
            String string = objectMapper.writeValueAsString(users);
            System.out.println("string = " + string);
            return Message.success(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Message.fail();
        }
    }
}
