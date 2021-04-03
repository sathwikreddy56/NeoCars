package com.example.Utils.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.Utils.Security.Admin.AdminDetailsServiceImpl;
import com.example.Utils.Security.User.UserDetailsServiceImpl;
import com.example.Utils.Security.Super.SuperDetailsServiceImpl;
import com.example.Utils.Security.jwt.AuthEntryPointJwt;

import com.example.Utils.Security.jwt.Admin.AdminAuthTokenFilter;
import com.example.Utils.Security.jwt.User.UserAuthTokenFilter;
import com.example.Utils.Security.jwt.Super.SuperAuthTokenFilter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	//start
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	AdminDetailsServiceImpl adminDetailsService;
	
	@Autowired
	SuperDetailsServiceImpl superDetailsService;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	@Bean
	public UserAuthTokenFilter authenticationJwtTokenFilter() {
		return new UserAuthTokenFilter();
	}
	@Bean
	public AdminAuthTokenFilter authenticationJwtTokenFilter1() {
		return new AdminAuthTokenFilter();
	}
	@Bean
	public SuperAuthTokenFilter authenticationJwtTokenFilter2() {
		return new SuperAuthTokenFilter();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(adminDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
			
			.antMatchers("/user/login").permitAll()
			.antMatchers("/admin/login").permitAll()
			.antMatchers("/super/login").permitAll()
			.antMatchers("/user/signup").permitAll()
			.antMatchers("/admin/signup").permitAll()
			.antMatchers("/user/**").hasAuthority("user")
			.antMatchers("/admin/**").hasAuthority("admin")
			.antMatchers("/super/**").hasAuthority("super")
			.anyRequest().authenticated()
		;
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(authenticationJwtTokenFilter1(), UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(authenticationJwtTokenFilter2(), UsernamePasswordAuthenticationFilter.class);
	}
	
	
	
	
}
