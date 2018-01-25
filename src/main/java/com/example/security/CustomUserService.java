package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.dao.SysUserRepository;
import com.example.po.SysUser;

public class CustomUserService implements UserDetailsService { //自定义UserDetailsService接口
	@Autowired
	SysUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername方法获取用户
		
		SysUser user = userRepository.findByUsername(username); 
		if(user == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		return user; //我们当前的用户实现了UserDetails接口，可直接返回给Spring Security使用
	}

}
