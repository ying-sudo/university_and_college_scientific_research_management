package cn.edu.sicnu;

import cn.edu.sicnu.dao.UsersDao;
import cn.edu.sicnu.entity.Users;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test {
    @Resource
    private UsersDao usersDao;

    @Test
    public void findAll(){
//        usersDao.selectList(null).forEach(user -> System.out.println("user = " + user));
        Page<Users> page = new Page<>(1,2);
        IPage<Users> iPage = usersDao.selectPage(page, null);
        long total = iPage.getTotal();
        System.out.println("total = " + total);
        iPage.getRecords().forEach(i-> System.out.println("i = " + i));
    }
}
