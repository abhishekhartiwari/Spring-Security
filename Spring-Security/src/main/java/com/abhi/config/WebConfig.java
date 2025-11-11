package com.abhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.abhi.interceptors.HomeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new  HomeInterceptor())
			.addPathPatterns("/api/**")
			.excludePathPatterns("/api/auth/**");
		
	}
	
	
	

}
