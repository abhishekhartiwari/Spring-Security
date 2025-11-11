package com.abhi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityCo {

		
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.ldapAuthentication()
	        .userDnPatterns("uid={0},ou=people")
	        .groupSearchBase("ou=groups")
	        .contextSource()
	        .url("ldap://localhost:8389/dc=springframeowrk,dc=org")
	        .and()
	        .passwordCompare()
	        .passwordEncoder(new LdapShaPasswordEncoder())
	        .passwordAttribute("userPassword");
	    }
	
	@Bean
	FormLoginConfigurer<HttpSecurity> configure(HttpSecurity http) throws Exception {
	    return http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();

	}
}
