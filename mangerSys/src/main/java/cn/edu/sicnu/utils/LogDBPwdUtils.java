package cn.edu.sicnu.utils;

import org.apache.log4j.jdbc.JDBCAppender;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.springframework.stereotype.Component;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.utils
 * @date 2020/11/30 22:16
 */
//@Component
public class LogDBPwdUtils extends JDBCAppender {

    StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
    EnvironmentPBEConfig config = new EnvironmentPBEConfig();

    @Override
    public void setPassword(String password) {
        config.setPassword("ljk");
        standardPBEStringEncryptor.setConfig(config);
        this.databasePassword = standardPBEStringEncryptor.decrypt(password);
    }
}
