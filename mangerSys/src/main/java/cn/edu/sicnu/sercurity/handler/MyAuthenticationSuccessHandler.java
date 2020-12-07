package cn.edu.sicnu.sercurity.handler;

//import cn.edu.sicnu.sercurity.utils.TokenUtil;
import cn.edu.sicnu.sercurity.utils.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

//登录成功处理逻辑
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //Authentication：登录成功后的返回数据
        //System.out.println(authentication.getName()+","+authentication.getAuthorities());

        //UserDetails后续会将该接口提供的用户信息封装到认证
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("userDetails = " + userDetails.toString());
        SecurityContextHolder.getContext().setAuthentication(authentication);//重新设置用户

        //生成token
        String token = TokenUtil.generateToken(userDetails);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("resultCode", 0);
        map.put("resultMsg", "登录成功");
//        map.put("token", token);
        map.put("data",authentication.getAuthorities());
        response.setContentType("Application/json;charset=UTF-8");
        Writer writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(map));
        writer.flush();
        writer.close();
    }
}
