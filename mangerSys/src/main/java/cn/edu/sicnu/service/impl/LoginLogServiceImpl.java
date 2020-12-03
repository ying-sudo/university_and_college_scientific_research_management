package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.LoginLogDao;
import cn.edu.sicnu.entity.LoginLog;
import cn.edu.sicnu.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service.impl
 * @date 2020/11/30 18:19
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public int deleteById(String loginLogId) {
        return loginLogDao.deleteById(loginLogId);
    }

    @Override
    public List<LoginLog> findAll() {
        return loginLogDao.findAll();
    }
}
