package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.LoginLog;

import java.util.List;

/**
 * 登录日志
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service
 * @date 2020/11/30 18:17
 */
public interface LoginLogService {

    List<LoginLog> findAll();

    int deleteById(String loginLogId);
}
