package cn.edu.sicnu;

import cn.edu.sicnu.controller.getRights;
import cn.edu.sicnu.service.impl.CollegeServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class test {
    @Resource
    private CollegeServiceImpl collegeService;
    private Logger logger=Logger.getLogger(test.class);
    @Test
    public void findAll(){
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
        getRights get = new getRights();
        get.insertLog();
//        collegeService.findAll().forEach(user-> System.out.println("user = " + user));
//        User user=new User("003","123456789","xhw","12345678912","2","521565000000322","2020-11-17","无");
    }
}
