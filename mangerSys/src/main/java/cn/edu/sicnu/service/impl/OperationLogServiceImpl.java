package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.OperationLogDao;
import cn.edu.sicnu.entity.OperationLog;
import cn.edu.sicnu.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 操作日志
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service.impl
 * @date 2020/12/3 9:32
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogDao operationLogDao;

    /**
     * 查找所有操作日志
     *
     * @return 所有日志记录
     */
    @Override
    @Transactional
    public List<OperationLog> findAll() {
        return operationLogDao.findAll();
    }

    /**
     * 删除一条日志记录，根据日志记录id
     * 出现异常就回滚
     *
     * @param OperationLogId operation_log表中的主码
     * @return 删除行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(String OperationLogId) {
        return operationLogDao.deleteById(OperationLogId);
    }
}
