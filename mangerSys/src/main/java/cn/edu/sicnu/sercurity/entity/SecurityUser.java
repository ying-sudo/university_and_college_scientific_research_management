package cn.edu.sicnu.sercurity.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 封装user和权限的实体类
 */
public class SecurityUser implements UserDetails {
    //当前登录用户
    private transient MyUser currentUsersInfo;
    //当前角色
    private List<String> permissionValueList;


    public MyUser getCurrentUsersInfo() {
        return currentUsersInfo;
    }

    public void setCurrentUsersInfo(MyUser currentUsersInfo) {
        this.currentUsersInfo = currentUsersInfo;
    }

    public List<String> getPermissionValueList() {
        return permissionValueList;
    }

    public void setPermissionValueList(List<String> permissionValueList) {
        this.permissionValueList = permissionValueList;
    }



    public SecurityUser(){

    }
    public SecurityUser(MyUser users){
        if(users!=null){
            this.currentUsersInfo=users;
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        for(String permissionValue : permissionValueList){
            if(StringUtils.isEmpty(permissionValue)) continue;
            SimpleGrantedAuthority authority=new SimpleGrantedAuthority(permissionValue);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUsersInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return currentUsersInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "SecurityUser{" +
                "currentUsersInfo=" + currentUsersInfo +
                ", permissionValueList=" + permissionValueList +
                '}';
    }
}
