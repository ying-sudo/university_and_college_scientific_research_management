package cn.edu.sicnu.sercurity.config;


import cn.edu.sicnu.sercurity.filter.TokenAuthFilter;
import cn.edu.sicnu.sercurity.filter.TokenLoginFilter;
import cn.edu.sicnu.sercurity.service.UnauthEntryPoint;
import cn.edu.sicnu.sercurity.service.MyLogoutHandler;
import cn.edu.sicnu.sercurity.utils.DefaultPasswordEncoder;
import cn.edu.sicnu.sercurity.utils.TokenManger;
import cn.edu.sicnu.service.CharactersRightService;
import cn.edu.sicnu.service.UserCharacterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 主配置类，一切关于security的配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private TokenManger tokenManger;
    private RedisTemplate redisTemplate;
    private DefaultPasswordEncoder defaultPasswordEncoder;
    private UserDetailsService userDetailsService;

    @Resource
    private DataSource dataSource;
    @Resource
    private UserCharacterService userCharacterService;
    @Resource
    private CharactersRightService charactersRightService;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    public WebSecurityConfig(TokenManger tokenManger,RedisTemplate redisTemplate,
                             DefaultPasswordEncoder defaultPasswordEncoder,UserDetailsService userDetailsService){
        this.userDetailsService=userDetailsService;
        this.defaultPasswordEncoder=defaultPasswordEncoder;
        this.tokenManger=tokenManger;
        this.redisTemplate=redisTemplate;
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
        http.cors().configurationSource(CorsConfigurationSource());

        http.exceptionHandling()
                .authenticationEntryPoint(new UnauthEntryPoint())
                .and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("user/logout").logoutSuccessUrl("/login")
                .addLogoutHandler(new MyLogoutHandler(tokenManger,redisTemplate)).and()
                .addFilter(new TokenLoginFilter(authenticationManager(),tokenManger,redisTemplate,userCharacterService,charactersRightService))
                .addFilter(new TokenAuthFilter(authenticationManager(),tokenManger,redisTemplate)).httpBasic()
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)
                .userDetailsService(userDetailsService)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);//排除session

    }
    //调用userDetailsService和密码处理
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
    }
    //不用认证就可以访问的接口
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/sorts/**")
                .antMatchers("/colleges/**")
                .antMatchers("/home/**")
                .antMatchers("/user/initPWD");
    }
}
