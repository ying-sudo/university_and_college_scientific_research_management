package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.entity.CharactersRight;
import cn.edu.sicnu.entity.UserCharacter;
import cn.edu.sicnu.entity.Users;
import cn.edu.sicnu.sercurity.entity.MyUser;
import cn.edu.sicnu.sercurity.entity.SecurityUser;
import cn.edu.sicnu.sercurity.utils.DefaultPasswordEncoder;
import cn.edu.sicnu.service.CharactersRightService;
import cn.edu.sicnu.service.CharactersService;
import cn.edu.sicnu.service.RightsService;
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
    private CharactersRightService charactersRightService;
    @Resource
    private RightsService rightsService;

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
        //通过角色id获取权限id
        List<CharactersRight> charactersRights = charactersRightService.queryByCharacterId(userCharacters.getCharacterId());
        List<String> list = new ArrayList<>();
        //把权限取出来放到list中
        for (CharactersRight charactersRight : charactersRights) {
            list.add(rightsService.queryById(charactersRight.getRightId()).getUrlPath());
        }
        SecurityUser securityUser=new SecurityUser();
        securityUser.setPermissionValueList(list);
        System.out.println("myUser = " + myUser);
//        myUser.setPassword(defaultPasswordEncoder.encode(myUser.getPassword()));
        securityUser.setCurrentUsersInfo(myUser);
        return securityUser;
    }
}
