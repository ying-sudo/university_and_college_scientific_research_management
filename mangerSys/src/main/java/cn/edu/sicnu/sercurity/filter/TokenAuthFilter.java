package cn.edu.sicnu.sercurity.filter;

import cn.edu.sicnu.sercurity.utils.TokenManger;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.trim;

/**
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 */
public class TokenAuthFilter extends BasicAuthenticationFilter {

    private TokenManger tokenManger;
    private RedisTemplate redisTemplate;


    public TokenAuthFilter(AuthenticationManager authenticationManager,TokenManger tokenManger,RedisTemplate redisTemplate) {
        super(authenticationManager);
        this.tokenManger=tokenManger;
        this.redisTemplate=redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        //获取当前认证成功的用户权限信息
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        System.out.println("authentication = " + authentication);
        //判断有权限的话，放到权限上下文中
        if(authentication!=null){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request,response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        //header中获取到名字
        String token = request.getHeader("authorization");
        if(token!=null){
            //从token中获取用户名
            String username = tokenManger.getUserInfoFromToken(token);
            System.out.println("username = " + username);
            //从redis中获取权限列表
            List<String> permissionValuelist=(ArrayList<String>) redisTemplate.opsForValue().get(username);
            System.out.println("permissionValuelist = " + permissionValuelist.toString());
            String[] split = permissionValuelist.toString().substring(1, permissionValuelist.toString().length() - 1).split(",");
            Collection<GrantedAuthority> authorities=new ArrayList<>();
            for (String s : split) {
                System.out.println("s = " + trim(s));
                SimpleGrantedAuthority auth =new SimpleGrantedAuthority(trim(s).substring(11,trim(s).length()-1));
                authorities.add(auth);
            }
            return new UsernamePasswordAuthenticationToken(username,token,authorities);
        }
        return null;
    }


}
