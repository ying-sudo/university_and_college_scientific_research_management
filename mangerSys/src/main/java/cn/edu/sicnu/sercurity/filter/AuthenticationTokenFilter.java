package cn.edu.sicnu.sercurity.filter;

import cn.edu.sicnu.sercurity.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

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
import java.io.Writer;
import java.util.*;

/**
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 */
public class AuthenticationTokenFilter extends BasicAuthenticationFilter {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//
    public AuthenticationTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String url = request.getRequestURI();
        //System.out.println("=========="+url);
        //String AUTHORIZATION = "Authorization";//表头授权
        String header = request.getHeader(TokenUtil.AUTHORIZATION);
        //System.out.println(header);

        if (header == null || !header.startsWith(TokenUtil.TOKEN_PREFIX)) {
            getResponse(response, "token不合法！");
            //chain.doFilter(request,response);//执行下一个过滤器
            return;
        }
        final String authToken = header.substring(TokenUtil.TOKEN_PREFIX.length());//真正的token
        //System.out.println("token" + authToken);
        if (TokenUtil.isTokenExpired(authToken)) {
            getResponse(response, "token过期！");
            return;
        }
        String username = TokenUtil.getUsernameFromToken(authToken);
        //System.out.println("name:" + username);
        if (username == null || username == "") {
            getResponse(response, "token错误！");
            return;
        }
        // 如果请求头中有token,并且格式正确，则进行解析，重新用户设置认证信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(header));
        super.doFilterInternal(request, response, chain);
        //chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {

        //获取到名字
        String token = tokenHeader.replace(TokenUtil.TOKEN_PREFIX, "");
        String username = TokenUtil.getUsernameFromToken(token);

        //获取到权限字符串，然后切分
        String authoritys = TokenUtil.getUseAythoritys(token);
        String[] authorityList = StringUtils.strip(authoritys, "[]").split(", ");

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //grantedAuthorities.add(new SimpleGrantedAuthority("emp:getList"));
        String str = "authority=";
        for (String authority : authorityList) {
            //System.out.println("authory=" + authority);
            String curString = authority.substring(str.length() + 1, authority.length() - 1);
            //System.out.println("auth=" + curString);
            grantedAuthorities.add(new SimpleGrantedAuthority(curString));
        }
        //System.out.println("grant=" + grantedAuthorities);
        if (username != null) {
            return new UsernamePasswordAuthenticationToken(username, null,
                    grantedAuthorities);
        }
        return null;
    }

    /**
     * 组装token验证失败的返回
     */
    private HttpServletResponse getResponse(HttpServletResponse response, String msg) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("resultCode","-1");//201默认未登录，或者登录时效已过
        map.put("resultMsg", msg);
        response.setContentType("Application/json;charset=UTF-8");
        Writer writer = response.getWriter();
        System.out.println(map);
        //System.out.println(objectMapper.writeValueAsString(map));
        writer.write(objectMapper.writeValueAsString(map));
        writer.flush();
        writer.close();
        return response;
    }

}
