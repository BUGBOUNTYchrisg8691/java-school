package com.lambdaschool.schools.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * The type Swagger 2 config.
 */
@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Config
{
	
	/**
	 * Api docket.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lambdaschool.schools"))
				.paths(regex("/.*"))
				.build()
				.apiInfo(apiEndPointsInfo());
	}
	
	private ApiInfo apiEndPointsInfo()
	{
		return new ApiInfoBuilder().title("Schools").description("Java - Unit 4 - Sprint 3 - Module 1 - Project")
				.contact(new Contact("Christopher Girvin",
						"http://github.com/bugbountychrisg8691",
						"chrisg8691@gmail.com")).license("MIT")
				.licenseUrl("https://github.com/BUGBOUNTYchrisg8691/java-school/blob/master/LICENSE")
				.version("1.0.0")
				.build();
	}
}


