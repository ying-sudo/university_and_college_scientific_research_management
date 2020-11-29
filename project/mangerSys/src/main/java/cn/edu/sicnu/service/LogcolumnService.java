package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.Logcolumn;

/**
 * (Logcolumn)表服务接口
 *
 * @author makejava
 * @since 2020-11-28 20:45:11
 */
public interface LogcolumnService {

    /**
     * 新增数据
     *
     * @param logcolumn 实例对象
     * @return 实例对象
     */
    int insert(Logcolumn logcolumn);
}