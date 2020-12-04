package cn.edu.sicnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.sicnu.dao")
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
