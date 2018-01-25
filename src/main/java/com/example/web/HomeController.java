package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.SysUserRepository;
import com.example.po.Msg;
import com.example.po.SysUser;

@Controller
public class HomeController {

	@Autowired
	private SysUserRepository sysUserRepository;
	@RequestMapping("/")
	public String index(Model model) {
		Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
		model.addAttribute("msg", msg);
		return "home";
	}

	@RequestMapping("/save")
	public String save(String username, String password) {
		SysUser sysUser = new SysUser();
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		sysUser.setPassword(encoder.encode(password.trim()));
		sysUser.setUsername(username);
		SysUser p = sysUserRepository.save(sysUser);
		return "login";
	}
}
