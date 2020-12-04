//package cn.edu.sicnu.utils;
//
//
//import org.apache.log4j.jdbc.JDBCAppender;
//import org.springframework.stereotype.Component;
////
//
/////**
//// * @author liangjin
//// * @version V1.0
//// * @package cn.edu.sicnu.utils
//// * @date 2020/11/30 22:16
//// */
//@Component
//public class LogDBPwdUtils extends JDBCAppender {
//
//    @Override
//    public void setPassword(String password) {
//        try {
//            password = DESUtil.decryptStr(password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        this.databasePassword = password;
//    }
//}
