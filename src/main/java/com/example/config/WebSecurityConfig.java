package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.security.CustomUserService;

/**
 * Spring Security配置
 * 
 * @author victor
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {// 扩展Spring  Security 配置需要继承WebSecurityConfigurerAdapter

	@Bean
	UserDetailsService customUserService() { // 注册CustomUserService的Bean
		return new CustomUserService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());// 添加自定义的user detail  service认证 并且密码保护
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**").permitAll()
				.antMatchers("/save*").permitAll()//默认不拦截
				.anyRequest().authenticated() // 所有请求需要认证即登录后才能访问
				.and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()// 定制登录行为，的呢过路页面可任意访问
				.defaultSuccessUrl("/") //默认登录成功后跳转页面
				.and().logout().permitAll(); // 定制注销行为，注销请求可以任意访问
	}

}
