package cn.edu.sicnu.sercurity.service;

import cn.edu.sicnu.controller.getRights;
import cn.edu.sicnu.entity.CharactersRight;
import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.service.CharactersRightService;
import cn.edu.sicnu.service.RightsService;
import cn.edu.sicnu.service.UserCharacterService;
import cn.edu.sicnu.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;
    @Resource
    private UserCharacterService userCharacterService;
    @Resource
    private CharactersRightService charactersRightService;
    @Resource
    private RightsService rightsService;
    @Resource
    private getRights get;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //获取当前登录用户
        System.out.println("username = " + username);
        Users users = userService.queryById(username);
        System.out.println("users = " + users);
        if (users == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pwd = passwordEncoder.encode(users.getPassword());
        users.setPassword(pwd); //如果没有加密，需要使用默认方式加密，
        //使用List将权限存储
//        List<CharactersRight> charactersRights = charactersRightService.queryByCharacterId(userCharacterService.queryByuserId(username).getCharacterId());
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        charactersRights.forEach(i-> System.out.println("i = " + i));

        //通过用户id获取权限
        String rightsByCharacters = get.getRightsByCharacters(username);
        System.out.println("rightsByCharacters = " + rightsByCharacters);
//        for(int i=0;i<charactersRights.size();i++){
//            System.out.println("charactersRights = " + rightsService.queryById(charactersRights.get(i).getRightId()));
        grantedAuthorities.add(new SimpleGrantedAuthority(rightsByCharacters));
//        }
        //密码验证在User中实现
        System.out.println("grantedAuthorities = " + grantedAuthorities);
        return new User(users.getId(), users.getPassword(), grantedAuthorities);
    }
}
