package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.po.SysUser;


public interface SysUserRepository extends JpaRepository<SysUser, Long>{
	
	SysUser findByUsername(String username);

}
