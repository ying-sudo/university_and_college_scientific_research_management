package cn.edu.sicnu;


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
    private static final Logger logger=Logger.getLogger(test.class);
    @Test
    public void findAll(){
        for(int i=0;i<50;i++){
            logger.debug(i);
            logger.info(i);
            logger.warn(i);
            logger.error(i);
            logger.fatal(i);
        }
    }
}
