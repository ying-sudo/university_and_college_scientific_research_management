package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.TeamMemberDao;
import cn.edu.sicnu.entity.TeamMember;
import cn.edu.sicnu.service.TeamMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TeamMember)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:34
 */
@Service("teamMemberService")
@Transactional
public class TeamMemberServiceImpl implements TeamMemberService {
    @Resource
    private TeamMemberDao teamMemberDao;

    /**
     * 通过ID查询单条数据
     *
     * @param teamId 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public TeamMember queryById(String teamId) {
        return this.teamMemberDao.queryById(teamId);
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
    public List<TeamMember> queryAllByLimit(int offset, int limit) {
        return this.teamMemberDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<TeamMember> findAll() {
        return this.teamMemberDao.findAll();
    }

    @Override
    public List<TeamMember> queryAll(TeamMember teamMember) {
        return this.teamMemberDao.queryAll(teamMember);
    }

    /**
     * 新增数据
     *
     * @param teamMember 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TeamMember insert(TeamMember teamMember) {
        this.teamMemberDao.insert(teamMember);
        return teamMember;
    }

    /**
     * 修改数据
     *
     * @param teamMember 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TeamMember update(TeamMember teamMember) {
        this.teamMemberDao.update(teamMember);
        return this.queryById(teamMember.getTeamId());
    }

    /**
     * 通过主键删除数据
     *
     * @param teamId 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(String teamId) {
        return this.teamMemberDao.deleteById(teamId) > 0;
    }
}