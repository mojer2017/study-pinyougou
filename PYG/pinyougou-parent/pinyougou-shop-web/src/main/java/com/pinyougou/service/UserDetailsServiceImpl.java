package com.pinyougou.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring Security 扩展权限认证类
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    //注入sellerService，未使用注解的方式
    private SellerService sellerService;
    public void setSellerService(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("进入了loadUserByUsername方法");
        //构造用户的角色列表
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        TbSeller seller = sellerService.findOne(username);
        //如果查找到相关商家信息，并且商家为已审核状态
        if (seller != null && "1".equals(seller.getStatus())) {
            //返回真实存在的用户，让Security框架对配置用户与密码信息是否匹配
            return new User(username, seller.getPassword(), authorities);
        } else {
            return null;
        }
    }
}
