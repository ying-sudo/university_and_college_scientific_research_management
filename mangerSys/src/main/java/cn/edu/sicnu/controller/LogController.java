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
    @PostMapping("/loginlog/{id}")
    public Message findAllLoginLog() {
        List<LoginLog> loginLogs = loginLogService.findAll();
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(loginLogs);
        return message;
    }

    /**
     * 批量删除登录日志记录
     *
     * @param deleteLogId 多个登录日志记录id，中间以逗号分隔
     * @return 通过resultCode分辨删除成功与否
     */
    @DeleteMapping("/loginlog")
    public Message deleteLoginLogByBatch(@RequestBody String deleteLogId) {
//        System.out.println(deleteLogId);
        String[] loginLogIdArr = deleteLogId.split(",");

        int i = 0;
        for (String eachId : loginLogIdArr) {
            i += loginLogService.deleteById(eachId);
        }

        if (i == loginLogIdArr.length) {
            message.setResultCode(0);
            message.setResultMsg("请求成功");
        } else {
            message.setResultCode(-1);
            message.setResultMsg("删除失败");
        }
        message.setData(null);
        return message;
    }

    /**
     * 查看系统日志列表
     *
     * @return message中data放入查到的数据
     */
    @PostMapping("/syslog/{id}")
    public Message findAllSysLog() {
        List<ManagerSystemLog> systemLogs = systemLogService.findAll();
        message.setData(0);
        message.setResultMsg("请求成功");
        message.setData(systemLogs);
        return message;
    }

    /**
     * 批量删除系统日志记录
     *
     * @param deleteLogId 多个登录日志记录id，中间以逗号分隔
     * @return 通过resultCode分辨删除成功与否
     */
    @DeleteMapping("/syslog")
    public Message deleteSysLogByBatch(@RequestBody String deleteLogId) {
        String[] sysLogIdArr = deleteLogId.split(",");

        int i = 0;
        for (String eachId : sysLogIdArr) {
            i += systemLogService.deleteById(eachId);
        }

        if (i == sysLogIdArr.length) {
            message.setResultCode(0);
            message.setResultMsg("请求成功");
        } else {
            message.setResultCode(-1);
            message.setResultMsg("删除失败");
        }
        message.setData(null);
        return message;
    }

    /**
     * 查看操作日志列表
     *
     * @return message中data放入查到的数据
     */
    @PostMapping("/operlog/{id}")
    public Message findAllOperLog(@PathVariable("id") String userId) {
        List<OperationLog> all = operationLogService.findAll();
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(all);
        return message;
    }

    /**
     * 批量删除系统日志
     *
     * @param deleteLogId 待删除系统日志表中的id
     * @return message中resultMsg返回删除成功与否
     */
    @DeleteMapping("/operlog")
    public Message deleteOperLogByBatch(@RequestBody String deleteLogId) {
        String[] operLogIdArr = deleteLogId.split(",");

        int i = 0;
        for (String eachId : operLogIdArr) {
            i += operationLogService.deleteById(eachId);
        }

        if (i == operLogIdArr.length) {
            message.setResultCode(0);
            message.setResultMsg("请求成功");
        } else {
            message.setResultCode(-1);
            message.setResultMsg("删除失败");
        }
        message.setData(null);
        return message;
    }

}
