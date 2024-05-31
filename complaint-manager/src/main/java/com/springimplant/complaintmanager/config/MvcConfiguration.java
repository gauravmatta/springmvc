package com.springimplant.complaintmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
    @Bean
    ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/jsp/");
        return resolver;
    }

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.springimplant"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfoMetaData());
    }
    
    ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder().title("Complaint Manager")
                .description("Complaint API")
                .contact(new Contact("Spring Implant", "https://www.springimplant.com/", "gaurav.matta.tech@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

}