package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.OperLogDao;
import cn.edu.sicnu.entity.OperLog;
import cn.edu.sicnu.service.OperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service.impl
 * @date 2020/11/30 18:19
 */
@Service
public class OperLogServiceImpl implements OperLogService {
    @Autowired
    private OperLogDao operLogDao;

    @Override
    public int deleteById(String operLogId) {
        return operLogDao.deleteById(operLogId);
    }

    @Override
    public List<OperLog> findAll() {
        return operLogDao.findAll();
    }
}
