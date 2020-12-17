package cn.edu.sicnu.sercurity.service;

import cn.edu.sicnu.sercurity.utils.SetResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户未授权时处理方法
 */
@Component
public class UnauthEntryPoint implements AuthenticationEntryPoint {



    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        SetResponse.REResponse(response,"-1","该用户未授权");
    }
}
