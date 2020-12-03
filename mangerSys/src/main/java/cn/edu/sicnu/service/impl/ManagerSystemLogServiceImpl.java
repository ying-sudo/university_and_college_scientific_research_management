package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.ManagerSystemLogDao;
import cn.edu.sicnu.entity.ManagerSystemLog;
import cn.edu.sicnu.service.ManagerSystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service.impl
 * @date 2020/12/1 17:51
 */
@Service
public class ManagerSystemLogServiceImpl implements ManagerSystemLogService {

    @Autowired
    ManagerSystemLogDao systemLogDao;

    @Override
    public List<ManagerSystemLog> findAll() {
        return systemLogDao.findAll();
    }

    @Override
    public int deleteById(String managerSystemLogId) {
        return systemLogDao.deleteById(managerSystemLogId);
    }
}
