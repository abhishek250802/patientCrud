package com.assessment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    final MyAuthManager myAuthManager;

//
    public SecurityConfig(MyAuthManager myAuthManager) {
	this.myAuthManager = myAuthManager;
	//
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.parentAuthenticationManager(myAuthManager);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests().antMatchers("/user").permitAll()
		.antMatchers(HttpMethod.POST,"/patient").hasAuthority("MBBS")
		.anyRequest().authenticated().and().httpBasic();
    }

}
