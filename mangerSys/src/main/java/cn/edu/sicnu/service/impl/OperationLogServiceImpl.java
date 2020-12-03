package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.OperationLogDao;
import cn.edu.sicnu.entity.OperationLog;
import cn.edu.sicnu.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service.impl
 * @date 2020/12/3 9:32
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogDao operationLogDao;

    @Override
    public List<OperationLog> findAll() {
        return operationLogDao.findAll();
    }

    @Override
    public int deleteById(String OperationLogId) {
        return operationLogDao.deleteById(OperationLogId);
    }
}
