package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.TeamMemberDao;
import cn.edu.sicnu.entity.TeamMember;
import cn.edu.sicnu.service.TeamMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TeamMember)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:34
 */
@Service("teamMemberService")
public class TeamMemberServiceImpl implements TeamMemberService {
    @Resource
    private TeamMemberDao teamMemberDao;

    /**
     * 根据团队id和团队成员id，查询一条记录
     *
     * @param teamId 团队id
     * @param userId 团队成员id，即userId
     * @return 如果存在返回团队成员对象，不存在返回null
     */
    @Override
    @Transactional
    public TeamMember queryById(String teamId, String userId) {
        return teamMemberDao.queryById(teamId, userId);
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

    /**
     * 通过传入对象进行模糊查询
     *
     * @param teamMember 传入对象
     * @return 所有符合条件的对象list
     */
    @Override
    @Transactional
    public List<TeamMember> queryAll(TeamMember teamMember) {
        return this.teamMemberDao.queryAll(teamMember);
    }

    /**
     * 新增数据，一次添加多个团队成员，有一个失败就是全部添加失败,进行回滚
     *
     * @param teamMemberList 团队成员列表
     * @return 新增成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(List<TeamMember> teamMemberList) {
        String teamId;
        String userId;
        int insert;
        for (TeamMember teamMember : teamMemberList) {
            teamId = teamMember.getTeamId();
            userId = teamMember.getUserId();
            if (teamMemberDao.queryById(teamId, userId) == null) {
                insert = this.teamMemberDao.insert(teamMember);
                if (insert != 1) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }
        }
        return true;
    }

    /**
     * 修改数据
     *
     * @param teamMember 实例对象
     * @return 修改成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(TeamMember teamMember) {
        String teamId = teamMember.getTeamId();
        String userId = teamMember.getUserId();
        if (teamMemberDao.queryById(teamId, userId) != null) {
            int update = this.teamMemberDao.update(teamMember);
            return update == 1;
        }
        return false;
    }

    /**
     * 通过主键删除数据
     *
     * @param teamId 主键
     * @return 删除成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String teamId, String userId) {
        if (teamMemberDao.queryById(teamId, userId) != null) {
            return this.teamMemberDao.deleteById(teamId, userId) > 0;
        }
        return false;
    }
}