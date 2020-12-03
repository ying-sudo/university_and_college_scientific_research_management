package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.OperationLog;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service
 * @date 2020/12/3 9:32
 */
public interface OperationLogService {
    /**
     * 查询所有记录
     * @return 对象列表
     */
    List<OperationLog> findAll();

    /**
     * 删除对应id（主码）的记录
     * @param OperationLogId operation_log表中的主码
     * @return
     */
    int deleteById(String OperationLogId);
}
