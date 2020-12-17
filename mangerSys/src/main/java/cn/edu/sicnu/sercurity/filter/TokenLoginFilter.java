package cn.edu.sicnu.sercurity.filter;

import cn.edu.sicnu.sercurity.entity.MyUser;
import cn.edu.sicnu.sercurity.entity.SecurityUser;
import cn.edu.sicnu.sercurity.utils.SetResponse;
import cn.edu.sicnu.sercurity.utils.TokenManger;
import cn.edu.sicnu.service.CharactersRightService;
import cn.edu.sicnu.service.UserCharacterService;
import cn.edu.sicnu.utils.getRights;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 登录授权过滤器，继承UsernamePasswordAuthenticationFilter，通过attemptAuthentication方法
 * 认证用户并授权，通过就跳转到successfulAuthentication方法，表明认证成功，失败则跳转到
 * unsuccessfulAuthentication方法中
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private TokenManger tokenManger;
    private RedisTemplate redisTemplate;
    private AuthenticationManager authenticationManager;
    private final org.slf4j.Logger loggingLogger = LoggerFactory.getLogger("loginInfo");
    private UserCharacterService userCharacterService;
    private CharactersRightService charactersRightService;


    public TokenLoginFilter(AuthenticationManager authenticationManager,TokenManger tokenManger,RedisTemplate redisTemplate,UserCharacterService userCharacterService,CharactersRightService charactersRightService){
        this.authenticationManager=authenticationManager;
        this.tokenManger=tokenManger;
        this.redisTemplate=redisTemplate;
        this.userCharacterService=userCharacterService;
        this.charactersRightService=charactersRightService;
        this.setPostOnly(false);
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login","POST"));
    }

    //获取表单提交的用户名和密码，认证用户
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            //获取提交的数据
            MyUser myUser = new ObjectMapper().readValue(request.getInputStream(), MyUser.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myUser.getUsername(),myUser.getPassword(),new ArrayList<>()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    //认证成功
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        //获取请求ip，并把它放到MDC容器中
        String ip = getRemoteHost(request);
        MDC.put("ipAddress", ip);
        //认证成功之后，得到用户信息
        SecurityUser user = (SecurityUser) authResult.getPrincipal();
        //把用户信息放到MDC容器中
        MDC.put("userId", user.getUsername());
        loggingLogger.info("登录成功");
        //生成token
        String token = tokenManger.createToken(user.getCurrentUsersInfo().getUsername());
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        //获取认证成功后用户的权限并返回给前端供其使用
        getRights get = new getRights(userCharacterService,charactersRightService);
        String rights = get.getRightsByCharacters(user.getUsername());
        //把用户的名称和角色列表信息放到redis
        redisTemplate.opsForValue().set(user.getCurrentUsersInfo().getUsername(),authorities);
        SetResponse.REResponse(response,"0",token,rights);
    }
    //认证失败
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException{
        loggingLogger.info("登录失败");
        SetResponse.REResponse(response,"-1","登录失败");
    }
    //获取ip
    private static String getRemoteHost(HttpServletRequest request) {
        // 反向代理后：转发请求的HTTP头信息中，增加了X-Real-IP信息
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("x-Forwarded-For");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

}
