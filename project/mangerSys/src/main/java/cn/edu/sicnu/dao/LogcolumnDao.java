package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.Logcolumn;

/**
 * (Logcolumn)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-28 20:45:10
 */
public interface LogcolumnDao {

    /**
     * 新增数据
     *
     * @param logcolumn 实例对象
     * @return 影响行数
     */
    int insert(Logcolumn logcolumn);

}