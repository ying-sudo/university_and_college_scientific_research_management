package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.OperLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.dao
 * @date 2020/11/30 18:11
 */
@Repository
public interface OperLogDao {

    /**
     * 查询所有记录
     * @return 对象列表
     */
    List<OperLog> findAll();

    /**
     * 删除对应id（主码）的记录
     * @param operLogId oper_log表中的主码
     * @return
     */
    int deleteById(String operLogId);
}
