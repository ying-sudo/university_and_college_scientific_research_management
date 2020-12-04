package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.LoginLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 登录日志dao接口
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.dao
 * @date 2020/11/30 18:11
 */
@Repository
public interface LoginLogDao {

    /**
     * 查询所有记录
     *
     * @return 对象列表
     */
    List<LoginLog> findAll();

    /**
     * 删除对应id（主码）的记录
     *
     * @param loginLogId oper_log表中的主码
     * @return 删除的行数
     */
    int deleteById(String loginLogId);
}
