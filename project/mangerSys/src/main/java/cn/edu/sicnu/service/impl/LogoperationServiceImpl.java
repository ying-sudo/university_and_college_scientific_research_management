package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.LogoperationDao;
import cn.edu.sicnu.entity.Logoperation;
import cn.edu.sicnu.service.LogoperationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Logoperation)表服务实现类
 *
 * @author makejava
 * @since 2020-11-28 20:45:11
 */
@Service("logoperationService")
@Transactional
public class LogoperationServiceImpl implements LogoperationService {
    @Resource
    private LogoperationDao logoperationDao;

    /**
     * 新增数据
     *
     * @param logoperation 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public void insert(Logoperation logoperation) {
        this.logoperationDao.insert(logoperation);
    }
}