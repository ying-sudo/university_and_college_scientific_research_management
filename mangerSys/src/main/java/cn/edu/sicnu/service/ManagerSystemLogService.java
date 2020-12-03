package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.LoginLog;
import cn.edu.sicnu.entity.ManagerSystemLog;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service
 * @date 2020/12/1 17:50
 */
public interface ManagerSystemLogService {

    List<ManagerSystemLog> findAll();

    int deleteById(String managerSystemLogId);
}
