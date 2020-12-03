package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.LoginLog;
import cn.edu.sicnu.entity.ManagerSystemLog;
import cn.edu.sicnu.entity.OperationLog;
import cn.edu.sicnu.service.LoginLogService;
import cn.edu.sicnu.service.ManagerSystemLogService;
import cn.edu.sicnu.service.OperationLogService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 查看和删除日志的controller
 * 包括登录日志，操作日志，系统日志的查看和修改
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.controller
 * @date 2020/11/30 18:24
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LogController {

    @Autowired
    private LoginLogService loginLogService;    //登录日志service

    @Autowired
    private ManagerSystemLogService systemLogService;   //系统日志service

    @Autowired
    private OperationLogService operationLogService;    //操作日志service

    @Autowired
    private Message message;

    /**
     * 查看登录日志列表
     *
     * @return message的data中放入查到的日志列表
     */
    @PostMapping("/loginlog")
    public Message findAllLoginLog() {
        List<LoginLog> loginLogs = loginLogService.findAll();
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(loginLogs);
        return message;
    }

    /**
     * 删除一条登录日志
     *
     * @param loginLogId 待删除的登录日志记录的id号
     * @return message中resultMsg返回删除成功与否
     */
    @DeleteMapping("/loginlog/{id}")
    public Message deleteLoginLogById(@PathVariable("id") String loginLogId) {
        int i = loginLogService.deleteById(loginLogId);
        if (i == 1) {
            message.setResultCode(0);
            message.setResultMsg("删除成功");
            message.setData(null);

        } else {
            message.setResultCode(-1);
            message.setResultMsg("删除失败");
            message.setData(null);
        }
        return message;
    }

    /**
     * 查看系统日志列表
     *
     * @return message中data放入查到的数据
     */
    @PostMapping("/syslog")
    public Message findAllSysLog() {
        List<ManagerSystemLog> systemLogs = systemLogService.findAll();
        message.setData(0);
        message.setResultMsg("请求成功");
        message.setData(systemLogs);
        return message;
    }

    /**
     * 删除一条系统日志
     *
     * @param sysLogId 待删除系统日志表中的id
     * @return message中resultMsg返回删除成功与否
     */
    @DeleteMapping("/syslog/{id}")
    public Message deleteSysLogById(@PathVariable("id") String sysLogId) {
        int i = systemLogService.deleteById(sysLogId);
        if (i == 1) {
            message.setResultCode(0);
            message.setResultMsg("删除成功");
            message.setData(null);
        } else {
            message.setResultCode(-1);
            message.setResultMsg("删除失败");
            message.setData(null);
        }
        return message;
    }

    /**
     * 查看操作日志列表
     *
     * @return message中data放入查到的数据
     */
    @PostMapping("/operlog")
    public Message findAllOperLog() {
        List<OperationLog> all = operationLogService.findAll();
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(all);
        return message;
    }

    /**
     * 删除一条操作日志
     *
     * @param operLogId 待删除操作日志表中的id
     * @return message中resultMsg返回删除成功与否
     */
    @DeleteMapping("/operlog/{id}")
    public Message deleteOperLogById(@PathVariable("id") String operLogId) {
        int i = operationLogService.deleteById(operLogId);
        if (i == 1) {
            message.setResultCode(0);
            message.setResultMsg("删除成功");
            message.setData(null);
        } else {
            message.setResultCode(-1);
            message.setResultMsg("删除失败");
            message.setData(null);
        }
        return message;
    }
}
