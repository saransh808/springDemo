package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringConfiguration {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.build()
				.apiInfo(metaData());
				
	}
	
	public ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"SORION APPLICATION DOCUMENTATION", 
				"SORION API SET FOR MANAGEMENT by Saransh Agarwal", 
				"0.0", 
				"", 
				"", 
				"", 
				null);
	
		return apiInfo;
	}

}
