package cn.edu.sicnu.sercurity.handler;

import cn.edu.sicnu.sercurity.utils.SetResponse;
import cn.edu.sicnu.sercurity.utils.TokenManger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


//重写退出成功方法
@Component
public class MyLogoutHandler implements LogoutHandler {
    @Resource
    private SetResponse setResponse;
    private TokenManger tokenManger;
    private RedisTemplate redisTemplate;


    public MyLogoutHandler(TokenManger tokenManger,RedisTemplate redisTemplate){
        this.tokenManger=tokenManger;
        this.redisTemplate=redisTemplate;
    }
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        //从header中获取token
        String token = request.getHeader("token");
        if(token!=null){
            tokenManger.removeToken(token);
            String username = tokenManger.getUserInfoFromToken(token);
            redisTemplate.delete(username);
        }

        //token 不为空，移除token，从redis中删除token

    }

//    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        Map<String,String> map = new LinkedHashMap<>();
//        map.put("resultCode", "0");
//        map.put("resultMsg", "退出成功");
//        response.setContentType("Application/json;charset=UTF-8");
//        Writer writer = response.getWriter();
//        try {
//            writer.write(objectMapper.writeValueAsString(map));
//            writer.flush();
//            writer.close();
//        }catch (IOException o){
//            o.printStackTrace();
//            if(writer != null){
//                writer.flush();
//                writer.close();
//            }
//        }
//    }
}
