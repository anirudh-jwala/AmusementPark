package com.cg.AmusementPark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
public class AmusementParkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmusementParkApplication.class, args);
	}

	/**
	 * Swagger UI Configuration
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.cg.AmusementPark")).paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Amusement Park API").version("2.0")
				.description("API for Amusement park angular application built with Spring Boot").build();
	}

}
