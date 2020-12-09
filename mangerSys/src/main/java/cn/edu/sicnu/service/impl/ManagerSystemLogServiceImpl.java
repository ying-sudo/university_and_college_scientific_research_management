package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.ManagerSystemLogDao;
import cn.edu.sicnu.entity.ManagerSystemLog;
import cn.edu.sicnu.service.ManagerSystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 系统日志
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service.impl
 * @date 2020/12/1 17:51
 */
@Service
public class ManagerSystemLogServiceImpl implements ManagerSystemLogService {

    @Autowired
    ManagerSystemLogDao systemLogDao;

    /**
     * 查找所有系统日志记录
     *
     * @return 所有系统日志
     */
    @Override
    public List<ManagerSystemLog> findAll() {
        return systemLogDao.findAll();
    }

    /**
     * 根据日志记录删除一条记录
     * 出现异常就回滚
     *
     * @param managerSystemLogId 日志记录
     * @return 删除行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(String managerSystemLogId) {
        return systemLogDao.deleteById(managerSystemLogId);
    }
}
