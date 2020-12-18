package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.LoginLog;
import cn.edu.sicnu.entity.ManagerSystemLog;
import cn.edu.sicnu.entity.OperationLog;
import cn.edu.sicnu.service.LoginLogService;
import cn.edu.sicnu.service.ManagerSystemLogService;
import cn.edu.sicnu.service.OperationLogService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 查看和删除日志的controller
 * 包括登录日志，操作日志，系统日志的查看和修改
 *
 * @author liangjin
 * @version V2.0
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

    /**
     * 查看登录日志列表
     *
     * @return message的data中放入查到的日志列表
     */
    @PreAuthorize("hasAnyAuthority('/admin')")
    @GetMapping("/loginlog")
    public Message findAllLoginLog() {
        List<LoginLog> loginLogs = loginLogService.findAll();
        return Message.success(loginLogs);
    }

    /**
     * 批量删除登录日志记录
     *
     * @param deleteLogId 多个登录日志记录id，中间以逗号分隔
     * @return 通过resultCode分辨删除成功与否
     */
    @PreAuthorize("hasAnyAuthority('/admin')")
    @DeleteMapping("/loginlog")
    public Message deleteLoginLogByBatch(@RequestBody String deleteLogId) {
        String[] loginLogIdArr = deleteLogId.split(",");

        int i = 0;
        for (String eachId : loginLogIdArr) {
            i += loginLogService.deleteById(eachId);
        }

        if (i == loginLogIdArr.length) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    /**
     * 查看系统日志列表
     *
     * @return message中data放入查到的数据
     */
    @PreAuthorize("hasAnyAuthority('/admin')")
    @GetMapping("/syslog")
    public Message findAllSysLog() {
        List<ManagerSystemLog> systemLogs = systemLogService.findAll();
        return Message.success(systemLogs);
    }

    /**
     * 批量删除系统日志记录
     *
     * @param deleteLogId 多个登录日志记录id，中间以逗号分隔
     * @return 通过resultCode分辨删除成功与否
     */
    @PreAuthorize("hasAnyAuthority('/admin')")
    @DeleteMapping("/syslog")
    public Message deleteSysLogByBatch(@RequestBody String deleteLogId) {
        String[] sysLogIdArr = deleteLogId.split(",");

        int i = 0;
        for (String eachId : sysLogIdArr) {
            i += systemLogService.deleteById(eachId);
        }

        if (i == sysLogIdArr.length) {
            return Message.success();
        } else {
            return Message.fail();

        }
    }

    /**
     * 查看操作日志列表
     *
     * @return message中data放入查到的数据
     */
    @PreAuthorize("hasAnyAuthority('/admin')")
    @GetMapping("/operlog")
    public Message findAllOperLog() {
        List<OperationLog> operLogs = operationLogService.findAll();
        return Message.success(operLogs);
    }

    /**
     * 批量删除系统日志
     *
     * @param deleteLogId 待删除系统日志表中的id
     * @return message中resultMsg返回删除成功与否
     */
    @PreAuthorize("hasAnyAuthority('/admin')")
    @DeleteMapping("/operlog")
    public Message deleteOperLogByBatch(@RequestBody String deleteLogId) {
        String[] operLogIdArr = deleteLogId.split(",");

        int i = 0;
        for (String eachId : operLogIdArr) {
            i += operationLogService.deleteById(eachId);
        }

        if (i == operLogIdArr.length) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }
    /**
     * 删除单条数据
     */
    @PreAuthorize("hasAnyAuthority('/admin')")
    @PostMapping("/deleteOne")
    public Message deleteOne(@RequestBody String id){
        try{
            operationLogService.deleteById(id);
            return Message.success();
        }catch (Exception e){
            return Message.fail();
        }
    }

}
