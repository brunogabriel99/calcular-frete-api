package transportes.sigabem.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
		
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("transportes.sigabem.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());
				
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Consulta de frete",
				"API de calculo de preço de frete",
				"1.0",
				"terms of service",
				new Contact("Bruno Chagas", "https://www.linkedin.com/in/brunogabriel99/", "brunogabriel92.bg@gmail.com"),
				"Apache license Version 2.0",
				"https://www.apache.org/license.html",
				new ArrayList<VendorExtension>());
		return apiInfo;
	}
}
