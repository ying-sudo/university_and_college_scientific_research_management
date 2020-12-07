package cn.edu.sicnu.sercurity.service;


import org.elasticsearch.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


/**
 *  注意和使用的名称一致
 * */
@Service("rbacauthorityservice")
public class Rbacauthorityservice {

    /**
     * 判断是否有权限访问
     * */
    public boolean hasPermission(HttpRequest request, Authentication authentication){

        Object userInfo = authentication.getPrincipal();//获取到用户信息
        System.out.println(userInfo);
        return  true;
    }
}
