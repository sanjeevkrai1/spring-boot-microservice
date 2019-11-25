package com.test.rest.webservices.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@SuppressWarnings("deprecation")
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Social Media application document",
			"Social Media application document", "v1.0", "", "sanjeev.rai1@u2opiamobile.com", "U2opia Licence", "http://u2opia-licence.come");
	private static final Set<String> DEFAULT_PRODUCE_AND_CONSUME = new HashSet<>(Arrays.asList("application/json" , "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
					.produces(DEFAULT_PRODUCE_AND_CONSUME)
					.consumes(DEFAULT_PRODUCE_AND_CONSUME);
	}

}
