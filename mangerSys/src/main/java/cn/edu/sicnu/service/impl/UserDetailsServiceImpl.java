package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.entity.UserCharacter;
import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.sercurity.entity.MyUser;
import cn.edu.sicnu.sercurity.entity.SecurityUser;
import cn.edu.sicnu.sercurity.utils.DefaultPasswordEncoder;
import cn.edu.sicnu.service.CharactersService;
import cn.edu.sicnu.service.UserCharacterService;
import cn.edu.sicnu.service.UserService;
import cn.edu.sicnu.utils.getRights;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;

    @Resource
    private UserCharacterService userCharacterService;

    @Resource
    private DefaultPasswordEncoder defaultPasswordEncoder;
    @Resource
    private CharactersService charactersService;
    @Resource
    private getRights get;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userService.queryById(username);
        if (users == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        MyUser myUser = new MyUser(users.getId(),users.getPassword());
        BeanUtils.copyProperties(users,myUser);
        //通过用户id获取该用户的角色
        UserCharacter userCharacters = userCharacterService.queryByuserId(username);
        //new一个getRights获取用户权限
        String rights = get.getRightsByCharacters(username);
        List<String> list = new ArrayList<>();
        list.add(charactersService.queryById(userCharacters.getCharacterId()).getName());
        list.add(rights);
        SecurityUser securityUser=new SecurityUser();
        securityUser.setPermissionValueList(list);
        myUser.setPassword(defaultPasswordEncoder.encode(myUser.getPassword()));
        securityUser.setCurrentUsersInfo(myUser);
        return securityUser;
    }
}
