package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.LoginLog;
import cn.edu.sicnu.service.LoginLogService;
import cn.edu.sicnu.service.ManagerSystemLogService;
import cn.edu.sicnu.utils.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.controller
 * @date 2020/11/30 18:24
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LogController {

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private ManagerSystemLogService systemLogService;

    @Autowired
    private Message message;

    @PostMapping("/operlog/{id}")
    public Message findAll(@PathVariable String id) {
        List<LoginLog> loginLogs = loginLogService.findAll();
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(loginLogs);
        if (id.equals("1234")) {

        }
        System.out.println(message);
        return message;
    }

    @DeleteMapping("/operlog/{id}")
    public Message deleteById(@PathVariable("id") String operLogId) {
        Logger logger = Logger.getLogger(this.getClass());
        logger.error("connected");
        int i = loginLogService.deleteById(operLogId);
        if (i == 1) {
            logger.error("删除了");
            message.setResultCode(0);
            message.setResultMsg("请求成功");
            message.setData(null);
        } else {
            message.setResultCode(-1);
            message.setResultMsg("请求失败");
            message.setData(null);
        }
        return message;

    }

    @PostMapping("/syslog/{id}")
    public Message findAllSysLog(@PathVariable String id) {
        List<ManagerSystemLog> systemLogs = systemLogService.findAll();
        message.setData(0);
        message.setResultMsg("请求成功");
        message.setData(systemLogs);
        return message;
    }
}
