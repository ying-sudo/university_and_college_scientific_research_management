package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.Logoperation;

/**
 * (Logoperation)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-28 20:45:11
 */
public interface LogoperationDao {

    /**
     * 新增数据
     *
     * @param logoperation 实例对象
     * @return 影响行数
     */
    void insert(Logoperation logoperation);


}