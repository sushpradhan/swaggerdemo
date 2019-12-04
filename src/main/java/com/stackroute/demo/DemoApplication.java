package com.stackroute.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
	   
import org.springframework.context.annotation.Bean;

import com.stackroute.config.JWTFilter;

@SpringBootApplication
public class DemoApplication {

	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		
		FilterRegistrationBean registrationbean = new FilterRegistrationBean();
		registrationbean.setFilter(new JWTFilter());
		registrationbean.addUrlPatterns("/api/v1/user/*");
		return registrationbean;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
