package cn.edu.sicnu.sercurity.filter;


import cn.edu.sicnu.sercurity.filter.AuthenticationTokenFilter;
import cn.edu.sicnu.sercurity.handler.MyAccessDeniedHandler;
import cn.edu.sicnu.sercurity.handler.MyAuthenticationEntryPoint;
import cn.edu.sicnu.sercurity.handler.MyAuthenticationFailureHandler;
import cn.edu.sicnu.sercurity.handler.MyAuthenticationSuccessHandler;
import cn.edu.sicnu.sercurity.handler.MyLogoutSuccessHandler;
import cn.edu.sicnu.sercurity.service.MyUsernamePasswordAuthenticationFilter;
import cn.edu.sicnu.sercurity.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;

@Configuration //相当于把该类作为spring的xml配置文件中的<beans>
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //未登陆时返回 JSON 格式的数据给前端（否则为 html）
    @Resource
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    //登录成功处理逻辑
    @Resource
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;

    //处理登录失败逻辑
    @Resource
    private MyAuthenticationFailureHandler authenticationFailureHandler;


    //退出登录成功处理逻辑
    @Resource
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    //权限拒绝处理逻辑
    @Resource
    private MyAccessDeniedHandler accessDeniedHandler;

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    //重写登录加载类
//    @Bean
//    public UserDetailsService myUserDetailsService() {
//        return new UserDetailsServiceImpl();
//    }

    //重写密码方法
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //重写验证方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    private CorsConfigurationSource CorsConfigurationSource() {
        CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");    //同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
        corsConfiguration.addAllowedHeader("*");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
        corsConfiguration.addAllowedMethod("*");    //允许的请求方法，PSOT、GET等
        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
        return source;
    }
    /**
     * 配置spring security的控制逻辑
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 新加入(cors) CSRF  取消跨站请求伪造防护 //由于使用的是JWT，我们这里不需要csrf
        http.cors().configurationSource(CorsConfigurationSource());//允许跨域访问
        http.cors().and().csrf().disable();
//        http.addFilterBefore(usernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()

                /** 解决跨域 **/
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                /** 任何尚未匹配的URL都只需要对用户进行身份验证  每个请求的url必须通过这个规则  RBAC 动态 url 认证 **/
                //.anyRequest().access("@rbacauthorityservice.hasPermission(request,authentication)")
                //登录
                .and()
                .formLogin()//开启登录, 定义当需要用户登录时候，转到的登录页面，默认post方法
//                .loginPage("http://localhost:8080/#/login")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("")
                .successHandler(authenticationSuccessHandler)// 登录成功
                .failureHandler(authenticationFailureHandler)// 登录失败
                .and().authorizeRequests()
                    .antMatchers("/","/login").permitAll()
                //退出
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(myLogoutSuccessHandler)

                // 不需要session
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                //异常处理(权限拒绝、登录失效等)
                .and().exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)//权限拒绝处理逻辑
                .authenticationEntryPoint(myAuthenticationEntryPoint)//匿名用户访问无权限资源时的异常处理

                //验证token
                .and()
                .addFilter(new AuthenticationTokenFilter(authenticationManager()));
        ;
//        http.addFilterAt(usernamePassword(), MyUsernamePasswordAuthenticationFilter.class);
        //用户未登录
//        http.httpBasic().authenticationEntryPoint(myAuthenticationEntryPoint);
//        UsernamePasswordAuthenticationFilter authenticationFilter=
//                new MyUsernamePasswordAuthenticationFilter();
//        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
//        http.addFilterAt(authenticationFilter,UsernamePasswordAuthenticationFilter.class);
    }

}
