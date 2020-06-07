package com.bluto.security.service;

import com.bluto.security.dao.SysUserMapper;
import com.bluto.security.model.SysUser;
import com.bluto.security.model.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * OAuthUserDetailService
 *
 * @author bluto
 * @Description: 客户详细信息服务
 * @date 2020/6/7 11:27
 */
@Service("oAuthUserDetailService")
public class OAuthUserDetailService implements UserDetailsService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUserExample example = new SysUserExample();
        example.createCriteria().andAccountEqualTo(s);
        List<SysUser> users = sysUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(users)) {
            SysUser user = users.get(0);
            return User.withUsername(user.getAccount()).password(user.getPassword()).authorities("p1").build();
        }

        return null;
    }
}
