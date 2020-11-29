package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.LogcolumnDao;
import cn.edu.sicnu.entity.Logcolumn;
import cn.edu.sicnu.service.LogcolumnService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Logcolumn)表服务实现类
 *
 * @author makejava
 * @since 2020-11-28 20:45:11
 */
@Service("logcolumnService")
@Transactional
public class LogcolumnServiceImpl implements LogcolumnService {
    @Resource
    private LogcolumnDao logcolumnDao;

    /**
     * 新增数据
     *
     * @param logcolumn 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(Logcolumn logcolumn) {
        return this.logcolumnDao.insert(logcolumn);
    }

}