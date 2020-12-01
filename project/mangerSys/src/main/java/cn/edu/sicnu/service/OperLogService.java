package cn.edu.sicnu.service;

import cn.edu.sicnu.dao.OperLogDao;
import cn.edu.sicnu.entity.OperLog;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.service
 * @date 2020/11/30 18:17
 */
public interface OperLogService {

    List<OperLog> findAll();

    int deleteById(String operLogId);
}
