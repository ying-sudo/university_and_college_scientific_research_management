package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.LoginLogDao;
import cn.edu.sicnu.entity.LoginLog;
import cn.edu.sicnu.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 登录日志
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service.impl
 * @date 2020/11/30 18:19
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * 登录日志删除接口，只要出现异常就回滚
     *
     * @param loginLogId 登录日志记录id
     * @return 删除行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(String loginLogId) {
        return loginLogDao.deleteById(loginLogId);
    }

    /**
     * 查看所有的登录日志记录
     *
     * @return 所有的登录日志
     */
    @Override
    @Transactional
    public List<LoginLog> findAll() {
        return loginLogDao.findAll();
    }
}
