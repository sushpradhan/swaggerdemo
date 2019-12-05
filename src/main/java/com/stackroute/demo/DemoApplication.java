package com.stackroute.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
	   
import org.springframework.context.annotation.Bean;

import com.stackroute.config.JWTFilter;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
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
	
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.stackroute.demo"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}
	
	@Bean
	public ApiInfo apiInfo() {
		
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		return apiInfoBuilder.title("Batch19 APIs")
					  .version("1.0")
					  .license("@ Batch19")
					  .description("All Endpoints !!! ").build();
		
		
	}
	
	
	
	
	
	

}
