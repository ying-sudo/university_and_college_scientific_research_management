package cn.edu.sicnu;

import cn.edu.sicnu.controller.getRights;
import cn.edu.sicnu.service.impl.CollegeServiceImpl;
import org.apache.log4j.Logger;
//import org.jasypt.encryption.StringEncryptor;
//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
//import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class test {
//    @Resource
//    private CollegeServiceImpl collegeService;
    private Logger logger=Logger.getLogger(test.class);

//    @Autowired
//    StringEncryptor stringEncryptor;
//
//    @Test
//    public void testEncrypt() {
////        调用encrypt方法加密，参数填写你的真实密码（即要加密的字符串）
//        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
//        EnvironmentPBEConfig config = new EnvironmentPBEConfig();
//        config.setPassword("ljk");
//        standardPBEStringEncryptor.setConfig(config);
//        String res = standardPBEStringEncryptor.encrypt("root");
//        System.out.println("res = " + res);
//        logger.error(res);
////        调用decrypt方法解密，参数为你加密后的字符串
////        logger.error(stringEncryptor.decrypt(res));
//    }

    @Test
    public void findAll(){
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
//        getRights get = new getRights();
//        get.insertLog();
//        collegeService.findAll().forEach(user-> System.out.println("user = " + user));
//        Users user=new Users("003","123456789","xhw","12345678912","2","521565000000322","2020-11-17","无");
    }
}
