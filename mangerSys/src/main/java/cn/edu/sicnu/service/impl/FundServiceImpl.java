package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.FundDao;
import cn.edu.sicnu.dao.ProjectDao;
import cn.edu.sicnu.dao.UserDao;
import cn.edu.sicnu.entity.Fund;
import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Fund)表服务实现类
 *
 * @author makejava
 * @since 2020-11-27 10:05:14
 */
@Service("fundService")
public class FundServiceImpl implements FundService {
    @Resource
    private FundDao fundDao;

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Fund queryById(String id) {
        return this.fundDao.queryById(id);
    }

    /**
     * 通过项目id获取项目的所有经费记录
     * 项目id 参数
     */
    @Override
    @Transactional
    public List<Fund> getFundByProjectId(String id) {
        return fundDao.getFundByProjectId(id);
    }

    /**
     * 根据用户id得到这个用户的所有项目，
     * 再查出这个用户所有项目的经费信息
     *
     * @param userId 用户id
     * @return 经费信息列表
     */
    @Override
    @Transactional
    public List<Fund> getFundByUserId(String userId) {
        List<Project> projectList = projectDao.queryByUserId(userId);
        List<Fund> fundList = new ArrayList<>();
        for (Project project : projectList) {
            List<Fund> projectFundList = fundDao.getFundByProjectId(project.getId());
            fundList.addAll(projectFundList);
        }
        for (Fund fund : fundList) {
            fund.setProjectName(projectDao.queryById(fund.getProjectId()).getName());
            fund.setUserName(userDao.queryById(projectDao.queryById(fund.getProjectId()).getUserId()).getName());
        }
        System.out.println(fundList);
        return fundList;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Fund> queryAllByLimit(int offset, int limit) {
        return this.fundDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Fund> findAll() {
        return this.fundDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param fund 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Fund insert(Fund fund) {
        this.fundDao.insert(fund);
        return fund;
    }

    /**
     * 修改数据
     *
     * @param fund 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Fund update(Fund fund) {
        this.fundDao.update(fund);
        return this.queryById(fund.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(String id) {
        return this.fundDao.deleteById(id) > 0;
    }
}