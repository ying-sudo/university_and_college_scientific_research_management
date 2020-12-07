package cn.edu.sicnu;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceMBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication()
@MapperScan("cn.edu.sicnu.dao")
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class Application {
    public static void main(String[] args) {
        try{
            SpringApplication.run(Application.class,args);
            System.out.println("success");
        }catch (Exception e){
            System.out.println("e = " + e);
        }

    }
}
